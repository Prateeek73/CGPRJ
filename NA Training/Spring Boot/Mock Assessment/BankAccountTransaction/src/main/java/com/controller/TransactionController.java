package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.BankTransaction;
import com.exception.InvalidBankTransactionException;
import com.service.ITransactionService;

@RestController
public class TransactionController {

    @Autowired
    private ITransactionService transactionService;

    @PostMapping("/insertTransaction/{accountNumber}")
    public BankTransaction insertTransaction(
            @PathVariable String accountNumber,
            @RequestBody BankTransaction transactionObj) throws InvalidBankTransactionException {
        return transactionService.insertTransaction(transactionObj, accountNumber);
    }

    @GetMapping("/viewTransactionByAccountNumber/{accountNumber}")
    public List<BankTransaction> viewTransactionByAccountNumber(@PathVariable String accountNumber) throws InvalidBankTransactionException {
        return transactionService.viewTransactionByAccountNumber(accountNumber);
    }

    @GetMapping("/viewTransactionByTransactionType/{transactionType}")
    public List<BankTransaction> viewTransactionByTransactionType(@PathVariable String transactionType) {
        return transactionService.viewTransactionByTransactionType(transactionType);
    }

    @GetMapping("/viewTransactionByTransactionTypeAndAmount/{transactionType}/{amount}")
    public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(
            @PathVariable String transactionType,
            @PathVariable double amount) {
        return transactionService.viewTransactionByTransactionTypeAndAmount(transactionType, amount);
    }

}
