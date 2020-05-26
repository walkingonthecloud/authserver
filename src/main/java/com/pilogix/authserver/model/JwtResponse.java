package com.pilogix.authserver.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public boolean isTokenValid() {
        return tokenValid;
    }

    private boolean tokenValid;

    public JwtResponse(String jwttoken, boolean tokenValid) {
        this.jwttoken = jwttoken;
        this.tokenValid = tokenValid;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
