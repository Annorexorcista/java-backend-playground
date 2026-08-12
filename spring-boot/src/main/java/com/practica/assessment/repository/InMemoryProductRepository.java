package com.practica.assessment.repository;

import com.practica.assessment.model.Product;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();

    public InMemoryProductRepository() {
        products.put(
                1L,
                new Product(1L, "Mouse", new BigDecimal("50.99"))
        );
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    @Override
    public Product save(Product product) {
        products.put(product.getId(), product);
        return product;
    }
}