package com.practica.assessment.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "products")
public class ProductDocument {

    @Id
    private String id;

    private String name;

    private BigDecimal price;


}
