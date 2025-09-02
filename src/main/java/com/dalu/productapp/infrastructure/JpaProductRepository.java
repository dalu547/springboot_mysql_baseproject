package com.dalu.productapp.infrastructure;

import com.dalu.productapp.domain.Product;
import com.dalu.productapp.domain.ProductRepository;
import com.dalu.productapp.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public class JpaProductRepository implements ProductRepository {

    private final SpringDataProductJpaRepository jpaRepo;
    private final ProductMapper mapper;

    public JpaProductRepository(SpringDataProductJpaRepository jpaRepo, ProductMapper mapper) {
        this.jpaRepo = jpaRepo;
        this.mapper = mapper;
    }

    @Override
    public Product save(Product product) {
        return mapper.toDomain(jpaRepo.save(mapper.toEntity(product)));
    }

    @Override
    public Optional<Product> findById(UUID id) {
        return jpaRepo.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Product> findAll() {
        return mapper.toDomainList(jpaRepo.findAll());
    }
}
