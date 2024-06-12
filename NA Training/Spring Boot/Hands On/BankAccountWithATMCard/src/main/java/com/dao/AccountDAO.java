package com.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Account;
import com.repository.AccountRepository;

@Repository
public class AccountDAO {
	
    private static final Logger logger = LoggerFactory.getLogger(AccountDAO.class);

	@Autowired
	private AccountRepository accountRepository;
	
	public void openAccount(Account account) {
		//fill code
		account = accountRepository.save(account);
		logger.info("Account with id {} added successfully", account.getAccountNumber());
	}
	
	public List<Account> retrieveAccountBasedOnCardType(String cardType){
		//fill code	
		List<Account> accounts = accountRepository.findByAtmCardCardType(cardType);
		if(accounts.isEmpty()) {
        	logger.info("No account with this card type {}", cardType);
		} else {
        	logger.info("Account details with card type {} retrieved successfully", cardType);
		}
		return accounts;
	}
}
