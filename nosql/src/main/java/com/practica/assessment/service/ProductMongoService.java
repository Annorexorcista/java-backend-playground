package com.practica.assessment.service;

import com.practica.assessment.model.ProductDocument;
import com.practica.assessment.repository.ProductMongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductMongoService {

    private final ProductMongoRepository repository;

    public ProductMongoService(ProductMongoRepository repository) {
        this.repository = repository;
    }


    // CREATE
    public ProductDocument create(ProductDocument product) {
        return repository.save(product);
    }


    // READ
    public Optional<ProductDocument> findById(String id) {
        return repository.findById(id);
    }


    public List<ProductDocument> findAll() {
        return repository.findAll();
    }


    // UPDATE
    public ProductDocument update(ProductDocument product) {
        return repository.save(product);
    }


    // DELETE
    public void delete(String id) {
        repository.deleteById(id);
    }
}