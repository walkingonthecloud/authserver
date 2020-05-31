package com.pilogix.authserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -4404134613499216631L;

    @JsonProperty("Username")
    private String username;

    @JsonProperty("Password")
    private String password;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @JsonProperty("Token")
    private String token;

    @JsonProperty("IsTokenValid")
    private boolean isTokenValid;

    @JsonProperty("ErrorMessage")
    private String errorMessage;

    //need default constructor for JSON Parsing
    public JwtResponse() {
    }

    public JwtResponse(String username, String password, String token, boolean isTokenValid) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.isTokenValid = isTokenValid;
    }

    public JwtResponse(String username, String password, String token, boolean isTokenValid, String errorMessage) {
        this.username = username;
        this.password = password;
        this.token = token;
        this.isTokenValid = isTokenValid;
        this.errorMessage = errorMessage;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isTokenValid() {
        return isTokenValid;
    }

    public void setTokenValid(boolean tokenValid) {
        isTokenValid = tokenValid;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
