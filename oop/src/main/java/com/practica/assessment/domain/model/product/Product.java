package com.practica.assessment.domain.model.product;

import java.math.BigDecimal;

public abstract class Product {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private ProductStatus status;

    protected Product(Long id,
                   String name,
                   String description,
                   BigDecimal price,
                   ProductStatus status) {

        validateId(id);
        validateName(name);
        validateDescription(description);
        validateStatus(status);

        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;

        changePrice(price);
    }

    public Long getId() {
        return id;
    }

    public abstract String getProductType();

    public void changePrice(BigDecimal newPrice){
        if (newPrice == null) {
            throw new IllegalArgumentException("El precio es obligatorio.");
        }

        if (newPrice.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("El precio debe ser mayor que cero.");
        }

        this.price = newPrice;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    private void validateId(Long id){
        if (id == null){
            throw new IllegalArgumentException("El id no puede ser nulo.");
        }

        if (id <= 0){
            throw new IllegalArgumentException("El id debe ser mayor a 0.");
        }
    }

    private void validateName(String name){
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    private void validateDescription(String description){
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("La descripción no puede estar vacío.");
        }
    }

    private void validateStatus(ProductStatus productStatus){
        if (productStatus == null) {
            throw new IllegalArgumentException("El estado del producto es obligatorio.");
        }
    }
}
