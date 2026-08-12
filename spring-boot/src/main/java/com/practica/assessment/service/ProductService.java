package com.practica.assessment.service;

import com.practica.assessment.exception.ResourceNotFoundException;
import com.practica.assessment.model.Product;
import com.practica.assessment.repository.ProductRepository;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Cacheable(value = "products", key = "#p0")
    public Product findById(Long id) {

        System.out.println("CONSULTANDO BASE DE DATOS...");

        return productRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Producto no encontrado"));
    }

    public Product create(Product product) {
        return productRepository.save(product);
    }
}