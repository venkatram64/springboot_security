package com.venkat.jwtsecurity.model;

public class AuthUserResponse {

    private final String jwt;

    public AuthUserResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
