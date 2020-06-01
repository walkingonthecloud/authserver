package com.pilogix.authserver.rest;

import com.pilogix.authserver.config.JwtTokenUtil;
import com.pilogix.authserver.model.JwtRequest;
import com.pilogix.authserver.model.JwtResponse;
import com.pilogix.authserver.model.UserDTO;
import com.pilogix.authserver.service.JwtUserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    public ResponseEntity<JwtResponse> createAuthenticationToken(@RequestBody JwtRequest request) {

        JwtResponse response = JwtResponse.builder().username(request.getUsername())
                .token(request.getToken()).build();

        try {
            authenticate(request.getUsername(), request.getPassword());
            final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);
            response.setTokenValid(true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Error while performing getToken() in AUTHSERVER.");
            response.setErrorMessage("Error while performing getToken() in AUTHSERVER.");
            response.setTokenValid(false);
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/validateToken", method = RequestMethod.POST)
    public ResponseEntity<?> validateAuthToken(@RequestHeader(value = "Authorization") String headerToken,
                                               @RequestBody JwtRequest request) {

        JwtResponse response = JwtResponse.builder().username(request.getUsername())
                .token(request.getToken()).build();

        try {
            request.setToken(headerToken);
            authenticate(request.getUsername(), request.getPassword());
            response.setTokenValid(true);
        } catch (Exception e) {
            e.printStackTrace();
            logger.debug("Error while performing validateToken() in AUTHSERVER.");
            response.setErrorMessage("Error while performing validateToken() in AUTHSERVER.");
            response.setTokenValid(false);
        }
        return ResponseEntity.ok(response);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

    private void authenticate(String username, String password) throws Exception {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);

        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
