package com.pilogix.authserver.model;

import java.io.Serializable;

public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;

    public Boolean isTokenValid() {
        return tokenValid;
    }

    private Boolean tokenValid;

    public JwtResponse(String jwttoken, Boolean tokenValid) {
        this.jwttoken = jwttoken;
    }

    public String getToken() {
        return this.jwttoken;
    }
}
