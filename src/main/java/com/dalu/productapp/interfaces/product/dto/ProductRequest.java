package com.dalu.productapp.interfaces.product.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @NotNull(message = "Price is required")
    private BigDecimal price;

    public ProductRequest() {
        // default constructor needed for Jackson (JSON → Object mapping)
    }

    public ProductRequest(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}

