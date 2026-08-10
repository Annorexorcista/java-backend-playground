package com.practica.assessment.infrastructure.adapter.out;

import com.practica.assessment.domain.model.product.Product;
import com.practica.assessment.domain.port.out.ProductRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class InMemoryProductRepository implements ProductRepository {

    private final Map<Long, Product> products = new HashMap<>();

    @Override
    public Product save(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }
}
