package com.dalu.productapp.infrastructure;

import com.dalu.productapp.domain.Product;
import com.dalu.productapp.domain.ProductRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public class JpaProductRepository implements ProductRepository {

    private final SpringDataProductJpaRepository jpaRepo;

    public JpaProductRepository(SpringDataProductJpaRepository jpaRepo) {
        this.jpaRepo = jpaRepo;
    }

    @Override
    public Product save(Product product) {
        return jpaRepo.save(ProductEntity.fromDomain(product)).toDomain();
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return jpaRepo.findById(id).map(ProductEntity::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return jpaRepo.findAll().stream().map(ProductEntity::toDomain).toList();
    }
}
