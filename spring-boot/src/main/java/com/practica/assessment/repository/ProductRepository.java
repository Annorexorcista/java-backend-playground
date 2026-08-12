package com.practica.assessment.repository;

import com.practica.assessment.model.Product;

import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Long id);

    Product save(Product product);
}
