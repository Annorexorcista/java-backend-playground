package com.practica.assessment.domain.exception;

public class ProductImportException extends Exception {

    public ProductImportException(String message) {
        super(message);
    }

    public ProductImportException(String message, Throwable cause) {
        super(message, cause);
    }
}
