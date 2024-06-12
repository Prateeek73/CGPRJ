package com.spring.app;

import com.spring.app.Account;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Driver {
	public static Account loadAccount(){
	    ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	   return context.getBean(Account.class, "account");
	}

	public static void main(String[] args) {
	    Account account = loadAccount();
	    
		System.out.println("Account number:" + account.getAccNumber());
		System.out.println("Account holder name:" + account.getAccHolderName());
		System.out.println("Balance:" + account.getAccBalance());
		Loan loanInfo = account.getLoanInfo();
		System.out.println("Loan type:" + loanInfo.getLoanType());
		System.out.println("Loan amount:" + loanInfo.getLoanAmount());
	}	 	  	    	    		        	 	
}