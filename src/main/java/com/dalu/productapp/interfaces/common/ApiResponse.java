package com.dalu.productapp.interfaces.common;

import java.time.Instant;

public record ApiResponse<T>(
        String status,
        T data,
        String message,
        Instant timestamp
) {
    public static <T> ApiResponse<T> success(T data, String message) {
        return new ApiResponse<>("success", data, message, Instant.now());
    }

    public static <T> ApiResponse<T> error(String message) {
        return new ApiResponse<>("error", null, message, Instant.now());
    }
}
