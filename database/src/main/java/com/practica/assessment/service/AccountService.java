package com.practica.assessment.service;

import com.practica.assessment.model.Account;
import com.practica.assessment.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    public void transfer(
            Long fromAccountId,
            Long toAccountId,
            BigDecimal amount) {

        Account from = accountRepository.findByIdForUpdate(fromAccountId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cuenta origen no encontrada"));

        Account to = accountRepository.findByIdForUpdate(toAccountId)
                .orElseThrow(() ->
                        new IllegalArgumentException("Cuenta destino no encontrada"));

        if (from.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }

        from.debit(amount);
        to.credit(amount);
    }

    @Transactional
    public void transferWithFailure(
            Long fromAccountId,
            Long toAccountId,
            BigDecimal amount) {

        Account from = accountRepository.findById(fromAccountId)
                .orElseThrow();

        Account to = accountRepository.findById(toAccountId)
                .orElseThrow();

        from.debit(amount);
        to.credit(amount);

        throw new RuntimeException("Error intencional para probar rollback");
    }
}