package com.practica.assessment.service;

import com.practica.assessment.model.Product;
import com.practica.assessment.repository.ProductRepository;

public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() ->
                        new IllegalArgumentException("Producto no encontrado"));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }
}
