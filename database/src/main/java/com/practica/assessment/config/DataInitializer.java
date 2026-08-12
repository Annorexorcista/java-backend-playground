package com.practica.assessment.config;

import com.practica.assessment.model.Account;
import com.practica.assessment.repository.AccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initDatabase(AccountRepository accountRepository) {
        return args -> {

            if (accountRepository.count() == 0) {
                accountRepository.save(
                        new Account(
                                "Alice",
                                new BigDecimal("1000.00")
                        )
                );

                accountRepository.save(
                        new Account(
                                "Bob",
                                new BigDecimal("500.00")
                        )
                );
            }
        };
    }
}