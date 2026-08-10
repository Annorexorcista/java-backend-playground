package com.practica.assessment.application.service;

import com.practica.assessment.domain.model.product.Product;
import com.practica.assessment.domain.port.out.ProductRepository;

import java.util.Optional;

public class ProductService {
    private final ProductRepository productRepository;


    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }
}
