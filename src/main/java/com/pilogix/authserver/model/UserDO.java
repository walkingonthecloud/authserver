package com.pilogix.authserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserDO {

    @JsonProperty("Username")
    private String username;

    @JsonProperty("Password")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
