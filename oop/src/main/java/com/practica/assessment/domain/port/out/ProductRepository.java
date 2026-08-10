package com.practica.assessment.domain.port.out;

import com.practica.assessment.domain.model.product.Product;

import java.util.Optional;

public interface ProductRepository {

    Product save(Product product);

    Optional<Product> findById(Long id);
}
