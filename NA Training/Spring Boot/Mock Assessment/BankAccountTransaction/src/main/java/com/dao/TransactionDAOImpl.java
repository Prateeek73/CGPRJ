package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Account;
import com.entities.BankTransaction;
import com.exception.InvalidBankTransactionException;
import com.repository.AccountRepository;
import com.repository.TransactionRepository;

@Component
public class TransactionDAOImpl implements ITransactionDAO {

	@Autowired
	private TransactionRepository transactionRepository;

	@Autowired
	private AccountRepository accountRepository; // Assuming you have an AccountRepository

	@Override
	public BankTransaction insertTransaction(BankTransaction transactionObj, String accountNumber) throws InvalidBankTransactionException {
		Account account = accountRepository.findById(accountNumber)
				.orElseThrow(() -> new InvalidBankTransactionException("Account not found for id : " + accountNumber));

		if ("Deposit".equals(transactionObj.getTransactionType())) {
			account.setBalanceAmount(account.getBalanceAmount() + transactionObj.getAmount());
		} else if ("Withdraw".equals(transactionObj.getTransactionType())) {
			if (transactionObj.getAmount() > account.getBalanceAmount()) {
				throw new InvalidBankTransactionException("Invalid Bank Transaction. Withdraw ammount more than available ammount." + 
									"\nWithdraw ammount: " + transactionObj.getAmount() +  
									"\nAvailable ammount : " + account.getBalanceAmount());
			}
			account.setBalanceAmount(account.getBalanceAmount() - transactionObj.getAmount());
		}

		transactionObj.setAccountObj(account);
		accountRepository.save(account); // Update account balance
		return transactionRepository.save(transactionObj);
	}

	@Override
	public List<BankTransaction> viewTransactionByAccountNumber(String accountNumber) throws InvalidBankTransactionException {
		accountRepository.findById(accountNumber)
				.orElseThrow(() -> new InvalidBankTransactionException("Account not found for id : " + accountNumber));
			
		return transactionRepository.findByAccountObj_AccountNumber(accountNumber);
	}

	@Override
	public List<BankTransaction> viewTransactionByTransactionType(String transactionType) {
		return transactionRepository.findByTransactionType(transactionType);
	}

	@Override
	public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(String transactionType, double amount) {
		return transactionRepository.findByTransactionTypeAndAmountGreaterThanEqual(transactionType, amount);
	}

}
