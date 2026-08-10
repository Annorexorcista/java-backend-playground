package com.practica.assessment;

import com.practica.assessment.application.service.ProductService;
import com.practica.assessment.domain.model.product.ProductStatus;
import com.practica.assessment.domain.model.product.capability.Sellable;
import com.practica.assessment.domain.model.product.digital.DigitalProduct;
import com.practica.assessment.domain.model.product.physical.PhysicalProduct;
import com.practica.assessment.domain.port.out.ProductRepository;
import com.practica.assessment.infrastructure.adapter.out.InMemoryProductRepository;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {

//        Product mouse =
//                new PhysicalProduct(1L,"GravastarM2","Buen mouse", BigDecimal.valueOf(50.99), ProductStatus.ACTIVE,30,0.65);
//
//        Product ebook =
//                new DigitalProduct(1L,"Obra negra","Recopilación de poesia",BigDecimal.valueOf(10.99),ProductStatus.ACTIVE,"www.ebook.com/obranegra",100);
//
//
////        mouse.changePrice(BigDecimal.valueOf(-100));
//
//        List<Product> catalog =
//                List.of(mouse, ebook);
//
//
//        for(Product product : catalog){
//
//            System.out.println("Price: " + product.getPrice() + " Type: " + product.getProductType());
//
//        }


        //Interface segregation principle
//        Sellable physical = new PhysicalProduct(1L,"GravastarM2","Buen mouse", BigDecimal.valueOf(50.99), ProductStatus.ACTIVE,30,0.65);
//        Sellable digital = new DigitalProduct(1L,"Obra negra","Recopilación de poesia",BigDecimal.valueOf(10.99),ProductStatus.ACTIVE,"www.ebook.com/obranegra",100);
//
//        physical.sell();
//        digital.sell();


        //Dependency injection
        ProductRepository repository =
                new InMemoryProductRepository();

        ProductService productService =
                new ProductService(repository);

    }

}