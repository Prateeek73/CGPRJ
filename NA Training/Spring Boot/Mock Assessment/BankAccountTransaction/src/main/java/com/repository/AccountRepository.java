package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

	List<Account> findByBalanceAmountGreaterThanEqual(double balance);

}