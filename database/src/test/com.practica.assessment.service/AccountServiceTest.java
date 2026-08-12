package com.practica.assessment.service;

import com.practica.assessment.model.Account;
import com.practica.assessment.repository.AccountRepository;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Test
    void shouldTransferMoneySuccessfully() {

        AccountRepository repository = mock(AccountRepository.class);

        AccountService service =
                new AccountService(repository);


        Account from = new Account(
                "Alice",
                new BigDecimal("1000.00")
        );

        Account to = new Account(
                "Bob",
                new BigDecimal("500.00")
        );


        when(repository.findByIdForUpdate(1L))
                .thenReturn(Optional.of(from));

        when(repository.findByIdForUpdate(2L))
                .thenReturn(Optional.of(to));


        service.transfer(
                1L,
                2L,
                new BigDecimal("100.00")
        );


        assertEquals(
                new BigDecimal("900.00"),
                from.getBalance()
        );

        assertEquals(
                new BigDecimal("600.00"),
                to.getBalance()
        );
    }


    @Test
    void shouldFailWhenBalanceIsInsufficient() {

        AccountRepository repository = mock(AccountRepository.class);

        AccountService service =
                new AccountService(repository);


        Account from = new Account(
                "Alice",
                new BigDecimal("50.00")
        );

        Account to = new Account(
                "Bob",
                new BigDecimal("500.00")
        );


        when(repository.findByIdForUpdate(1L))
                .thenReturn(Optional.of(from));

        when(repository.findByIdForUpdate(2L))
                .thenReturn(Optional.of(to));


        assertThrows(
                IllegalArgumentException.class,
                () -> service.transfer(
                        1L,
                        2L,
                        new BigDecimal("100.00")
                )
        );
    }
}