package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ITransactionDAO;
import com.entities.BankTransaction;
import com.exception.InvalidBankTransactionException;

@Service
@Transactional
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ITransactionDAO transactionDAO;

    @Override
    public BankTransaction insertTransaction(BankTransaction transactionObj, String accountNumber)
            throws InvalidBankTransactionException {
        return transactionDAO.insertTransaction(transactionObj, accountNumber);
    }

    @Override
    public List<BankTransaction> viewTransactionByAccountNumber(String accountNumber)
            throws InvalidBankTransactionException {
        return transactionDAO.viewTransactionByAccountNumber(accountNumber);
    }

    @Override
    public List<BankTransaction> viewTransactionByTransactionType(String transactionType) {
        return transactionDAO.viewTransactionByTransactionType(transactionType);
    }

    @Override
    public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(String transactionType, double amount) {
        return transactionDAO.viewTransactionByTransactionTypeAndAmount(transactionType, amount);
    }
}