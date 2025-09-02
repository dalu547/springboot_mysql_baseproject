package com.dalu.productapp.mapper;

import com.dalu.productapp.domain.Product;
import com.dalu.productapp.infrastructure.ProductEntity;
import com.dalu.productapp.interfaces.product.dto.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductEntity toEntity(Product product);
    Product toDomain(ProductEntity entity);
    ProductResponse toResponse(Product product);
    List<ProductResponse> toResponseList(List<Product> products);
    List<Product> toDomainList(List<ProductEntity> entities);
}
