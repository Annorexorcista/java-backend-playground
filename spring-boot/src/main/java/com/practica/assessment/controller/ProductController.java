package com.practica.assessment.controller;

import com.practica.assessment.model.Product;
import com.practica.assessment.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
@Tag(name = "Products", description = "Operaciones sobre productos")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(
            summary = "Obtener producto",
            description = "Obtiene un producto por su identificador"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Producto encontrado"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Producto no encontrado"
            )
    })
    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @Operation(
            summary = "Crear producto",
            description = "Crea un nuevo producto"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Producto creado"
    )
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.create(product);
    }
}