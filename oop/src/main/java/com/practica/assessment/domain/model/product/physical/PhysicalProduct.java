package com.practica.assessment.domain.model.product.physical;

import com.practica.assessment.domain.exception.InsufficientStockException;
import com.practica.assessment.domain.model.product.Product;
import com.practica.assessment.domain.model.product.ProductStatus;
import com.practica.assessment.domain.model.product.capability.Sellable;

import java.math.BigDecimal;

public class PhysicalProduct extends Product implements Sellable {

    private int stock;
    private double weight;

    public PhysicalProduct(Long id, String name, String description, BigDecimal price, ProductStatus status,int stock, double weight) {
        super(id, name, description, price, status);

        changeWeight(weight);
        increaseStock(stock);
    }


    public void increaseStock(int quantity){
        if (quantity <= 0){
            throw new IllegalArgumentException("El stock debe ser mayor a cero.");
        }
        this.stock += quantity;
    }

    public void decreaseStock(int quantity){
        if (quantity <= 0){
            throw new IllegalArgumentException("La cantidad debe ser mayor a 0.");
        }

        if (quantity > stock){
            throw new InsufficientStockException("No puedes quitar mas cantidad del stock disponible");
        }

        this.stock -= quantity;
    }

    private void validateWeight(double weight){
        if (weight <= 0){
            throw new IllegalArgumentException("El peso debe ser mayor a 0.");
        }
    }

    private void changeWeight(double weight) {
        validateWeight(weight);
        this.weight = weight;
    }

    @Override
    public String getProductType() {
        return "Physical";
    }

    @Override
    public void sell() {
        System.out.println("Selling...");
    }
}
