package com.dao;

import java.util.List;

import com.entities.Account;
import com.exception.InvalidAccountException;

public interface IAccountDAO {
	
	public Account openAccount(Account account);
	public Account updateAccountHolderPhoneNumber(String accountNumber,String phoneNumber) throws InvalidAccountException;
	public Account viewAccountByAccountNumber(String accountNumber) throws InvalidAccountException;
	public List<Account> viewAccountByBalance(double balance);
	
}