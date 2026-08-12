package com.practica.assessment.config;

import com.practica.assessment.service.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class TransactionRunner {

//    @Bean
//    @ConditionalOnProperty(
//            name = "app.demo.transactions",
//            havingValue = "true"
//    )
//    CommandLineRunner testTransfer(AccountService accountService) {
//        return args -> {
//            accountService.transfer(
//                    1L,
//                    2L,
//                    new BigDecimal("100.00")
//            );
//        };
//    }

    @Bean
    @ConditionalOnProperty(
            name = "app.demo.transactions",
            havingValue = "true"
    )
    CommandLineRunner testTransfer(AccountService accountService) {
        return args -> {
            accountService.transferWithFailure(
                    1L,
                    2L,
                    new BigDecimal("100.00")
            );
        };
    }
}