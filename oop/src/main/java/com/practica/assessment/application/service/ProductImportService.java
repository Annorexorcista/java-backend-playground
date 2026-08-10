package com.practica.assessment.application.service;

import com.practica.assessment.domain.exception.ProductImportException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductImportService {

    public String importProduct(Path file) throws ProductImportException {

        try {
            return Files.readString(file);
        } catch (IOException e) {
            throw new ProductImportException(
                    "No fue posible importar el producto.",
                    e
            );
        }
    }
}
