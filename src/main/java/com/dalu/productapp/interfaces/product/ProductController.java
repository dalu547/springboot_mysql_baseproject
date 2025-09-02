package com.dalu.productapp.interfaces.product;

import com.dalu.productapp.application.ProductService;
import com.dalu.productapp.domain.Product;
import com.dalu.productapp.interfaces.common.ApiResponse;
import com.dalu.productapp.interfaces.product.dto.ProductRequest;
import com.dalu.productapp.interfaces.product.dto.ProductResponse;
import com.dalu.productapp.mapper.ProductMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;
    private final ProductMapper mapper;

    public ProductController(ProductService service, ProductMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAll() {
        List<ProductResponse> products = mapper.toResponseList(service.getAll());
        return ResponseEntity.ok(ApiResponse.success(products, "Fetched products successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> create(@RequestBody @Valid ProductRequest request) {
        Product product = service.create(request.getName(), request.getPrice());
        ProductResponse response = mapper.toResponse(product);
        return ResponseEntity.ok(ApiResponse.success(response, "Product created successfully"));
    }

    @PutMapping("/{id}/price")
    public ResponseEntity<ApiResponse<ProductResponse>> updatePrice(@PathVariable UUID id,
                                                       @RequestParam double price) {
        Product updated = service.updatePrice(id, java.math.BigDecimal.valueOf(price));
        ProductResponse response = mapper.toResponse(updated);
        return ResponseEntity.ok(ApiResponse.success(response, "Price updated successfully"));
    }
}
