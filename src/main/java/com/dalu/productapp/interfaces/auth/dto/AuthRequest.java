package com.dalu.productapp.interfaces.auth.dto;

/**
 * DTO representing login credentials.
 */
public class AuthRequest {

    private String username;
    private String password;

    public AuthRequest() {
        // Default constructor needed for JSON deserialization
    }

    public AuthRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

