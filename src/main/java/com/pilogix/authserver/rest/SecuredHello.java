package com.pilogix.authserver.rest;

import com.pilogix.authserver.model.JwtRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/auth")
public class SecuredHello {

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    public ResponseEntity<String> helloWorld() throws Exception {
        return new ResponseEntity<>("Hello Secured World!", HttpStatus.OK);
    }
}
