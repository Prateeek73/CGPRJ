package com.dao;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.ATMCard;
import com.bean.Account;
import com.repository.ATMCardRepository;
import com.repository.AccountRepository;

@Repository
public class ATMCardDAO {

	private static final Logger logger = LoggerFactory.getLogger(ATMCardDAO.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private ATMCardRepository atmCardRepository;

	public void issueATMCardToAccount(int accountNumber, ATMCard atmCardObjet) {
		Optional<Account> accountOptional = accountRepository.findById(accountNumber);
		if (accountOptional.isPresent() && validCardType(atmCardObjet.getCardType())) {
			Account account = accountOptional.get();
			atmCardObjet.setAccount(account);
			atmCardRepository.save(atmCardObjet);
			logger.info("ATM card successfully issued to account number {}", accountNumber);
		}
		logger.info("ATM card not issued to account number {}", accountNumber);
	}

	private static boolean validCardType(String cardType) {
		return cardType.equals("VISA") || cardType.equals("Master") || cardType.equals("RuPay")
				|| cardType.equals("Maestro");
	}
}