package com.pilogix.authserver.service;

import com.pilogix.authserver.model.UserEntity;
import com.pilogix.authserver.repo.UserRepo;
import com.pilogix.authserver.util.Base64Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CustomAuthenticationManager implements AuthenticationManager {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    public CustomAuthenticationManager(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String user = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();

        UserEntity userEntity = userRepo.findByUsername(user);
        if (userEntity != null && userEntity.getPassword().equals(bcryptEncoder.encode(password))) {
            return new UsernamePasswordAuthenticationToken(user, password, new ArrayList<>());
        } else {
            throw new AuthenticationException("Authentication failed") {};
        }
    }
}
