package com.practica.assessment.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private Long id;

    private String name;

    private BigDecimal price;
}