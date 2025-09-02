package com.dalu.productapp.interfaces.product;

import com.dalu.productapp.application.ProductService;
import com.dalu.productapp.domain.Product;
import com.dalu.productapp.interfaces.common.ApiResponse;
import com.dalu.productapp.interfaces.product.dto.ProductRequest;
import com.dalu.productapp.interfaces.product.dto.ProductResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductResponse>>> getAll() {
        List<ProductResponse> products = service.getAll()
                .stream()
                .map(p -> new ProductResponse(p.getId(), p.getName(), p.getPrice()))
                .toList();
        return ResponseEntity.ok(ApiResponse.success(products, "Fetched products successfully"));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProductResponse>> create(@RequestBody @Valid ProductRequest request) {
        Product product = service.create(request.getName(), request.getPrice());
        ProductResponse response = new ProductResponse(product.getId(), product.getName(), product.getPrice());
        return ResponseEntity.ok(ApiResponse.success(response, "Product created successfully"));
    }

    @PutMapping("/{id}/price")
    public ResponseEntity<ApiResponse<ProductResponse>> updatePrice(@PathVariable UUID id,
                                                       @RequestParam double price) {
        Product updated = service.updatePrice(id, java.math.BigDecimal.valueOf(price));
        ProductResponse response = new ProductResponse(updated.getId(), updated.getName(), updated.getPrice());
        return ResponseEntity.ok(ApiResponse.success(response, "Price updated successfully"));
    }
}
