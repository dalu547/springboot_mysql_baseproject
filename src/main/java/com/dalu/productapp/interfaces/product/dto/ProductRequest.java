package com.dalu.productapp.interfaces.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Price is required")
    @Positive(message = "Price must be positive")
    private BigDecimal price;

    public ProductRequest() {
        // default constructor needed for Jackson (JSON → Object mapping)
    }

    public ProductRequest(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}

