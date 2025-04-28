package com.pilogix.authserver.service;


import com.pilogix.authserver.util.HashUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Custom password encoder that uses SHA-256 hashing algorithm.
 * (with _no_ salt! BCrypt encoder uses salt and inappropriate for our current use case)
 *
 * This class implements the PasswordEncoder interface from Spring Security.
 */
public class CustomPasswordEncoder implements PasswordEncoder{

    @Override
    public String encode(CharSequence rawPassword) {
        return HashUtils.getSHA256Hash(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return HashUtils.getSHA256Hash(charSequence.toString()).equals(s);
    }


}
