package com.practica.assessment.repository;

import com.practica.assessment.model.ProductDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductMongoRepository
        extends MongoRepository<ProductDocument, String> {

}