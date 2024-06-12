package com.service;

import java.util.List;

import com.entities.BankTransaction;
import com.exception.InvalidBankTransactionException;

public interface ITransactionService {

	public BankTransaction insertTransaction(BankTransaction transactionObj,String accountNumber) throws InvalidBankTransactionException;
	
	public List<BankTransaction> viewTransactionByAccountNumber(String accountNumber) throws InvalidBankTransactionException;
	
	
	public List<BankTransaction> viewTransactionByTransactionType(String transactionType);
	
	public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(String transactionType,double amount);

}
