package com.practica.assessment.service;

import com.practica.assessment.model.Product;
import com.practica.assessment.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {
    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @Test
    void shouldFindProductById() {

        Product product = new Product(
                1L,
                "Mouse",
                BigDecimal.valueOf(50.99)
        );

        when(productRepository.findById(1L))
                .thenReturn(Optional.of(product));

        Product result = productService.findById(1L);

        assertEquals(product, result);

        verify(productRepository).findById(1L);
    }

    @Test
    void shouldThrowExceptionWhenProductDoesNotExist() {

        when(productRepository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                IllegalArgumentException.class,
                () -> productService.findById(1L)
        );

        verify(productRepository).findById(1L);
    }

    @Test
    void shouldCreateProduct() {

        Product product = new Product(
                1L,
                "Mouse",
                BigDecimal.valueOf(50.99)
        );

        when(productRepository.save(product))
                .thenReturn(product);

        Product result = productService.create(product);

        assertEquals(product, result);

        verify(productRepository).save(product);
    }
}
