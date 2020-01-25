package com.venkat.jwtsecurity.model;

import java.io.Serializable;

public class AuthUserRequest  implements Serializable {

    private String username;
    private String password;

    public AuthUserRequest() {
    }

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
