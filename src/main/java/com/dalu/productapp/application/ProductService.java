package com.dalu.productapp.application;

import com.dalu.productapp.domain.Product;
import com.dalu.productapp.domain.ProductNotFoundException;
import com.dalu.productapp.domain.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(String name, BigDecimal price) {
        log.info("Creating product: {} with price {}", name, price);
        Product product = new Product(UUID.randomUUID(), name, price);
        return repository.save(product);
    }

    public List<Product> getAll() {
        log.debug("Fetching all products");
        return repository.findAll();
    }

    @Transactional
    public Product updatePrice(UUID id, BigDecimal price) {
        log.info("Updating price for product {} to {}", id, price);
        return repository.findById(id)
                .map(p -> {
                    p.updatePrice(price);
                    log.info("Successfully updated product {} to new price {}", id, price);
                    return repository.save(p);
                })
                .orElseThrow(() -> new ProductNotFoundException(id));
    }
}
