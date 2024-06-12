package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.BankTransaction;

public interface TransactionRepository extends JpaRepository<BankTransaction, String> {

    List<BankTransaction> findByAccountObj_AccountNumber(String accountNumber);
    List<BankTransaction> findByTransactionType(String transactionType);
    List<BankTransaction> findByTransactionTypeAndAmountGreaterThanEqual(String transactionType, double amount);

}