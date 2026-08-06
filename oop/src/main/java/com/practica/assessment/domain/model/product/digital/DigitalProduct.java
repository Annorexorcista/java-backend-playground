package com.practica.assessment.domain.model.product.digital;

import com.practica.assessment.domain.model.product.Product;
import com.practica.assessment.domain.model.product.ProductStatus;

import java.math.BigDecimal;

public class DigitalProduct extends Product {

    private String urlDownload;
    private long fileSize;

    public DigitalProduct(Long id, String name, String description, BigDecimal price, ProductStatus status, String urlDownload, long fileSize) {
        super(id, name, description, price, status);

        changeFileSize(fileSize);

        changeDownloadUrl(urlDownload);

    }

    private void changeDownloadUrl(String newUrl){
        if (newUrl == null){
            throw new IllegalArgumentException("El url no puede ser nulo.");
        } else if (newUrl.isBlank()) {
            throw new IllegalArgumentException("El url no puede estar vacío.");
        }

        this.urlDownload = newUrl;
    }

    private void changeFileSize(long fileSize) {

        if (fileSize <= 0){
            throw new IllegalArgumentException("El archivo debe tener un peso mayor a 0.");
        }

        this.fileSize = fileSize;
    }

    @Override
    public String getProductType() {
        return "Digital";
    }
}
