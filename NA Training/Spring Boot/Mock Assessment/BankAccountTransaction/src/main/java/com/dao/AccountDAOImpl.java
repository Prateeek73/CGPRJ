package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.entities.Account;
import com.exception.InvalidAccountException;
import com.repository.AccountRepository;

@Component
public class AccountDAOImpl implements IAccountDAO {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account openAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccountHolderPhoneNumber(String accountNumber, String phoneNumber) throws InvalidAccountException {
        Account account = viewAccountByAccountNumber(accountNumber);
        account.setPhoneNumber(phoneNumber);
        return accountRepository.save(account);
    }

    @Override
    public Account viewAccountByAccountNumber(String accountNumber) throws InvalidAccountException {
        return accountRepository.findById(accountNumber)
        		.orElseThrow(() -> new InvalidAccountException("Account not found for id : " + accountNumber));
    }

    @Override
    public List<Account> viewAccountByBalance(double balance) {
        return accountRepository.findByBalanceAmountGreaterThanEqual(balance);
    }

}
