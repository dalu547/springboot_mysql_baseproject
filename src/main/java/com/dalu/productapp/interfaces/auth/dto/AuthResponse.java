package com.dalu.productapp.interfaces.auth.dto;

/**
 * DTO returned after successful authentication containing JWT token.
 */
public class AuthResponse {

    private final String token;

    public AuthResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}

