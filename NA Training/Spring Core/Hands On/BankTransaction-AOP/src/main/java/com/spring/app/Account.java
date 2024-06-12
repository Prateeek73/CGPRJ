package com.spring.app;

public class Account {
	private int accountNo;
	private float accntBalance;
	private String accntHolderName;

	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public float getAccntBalance() {
		return accntBalance;
	}
	public void setAccntBalance(float accntBalance) {
		this.accntBalance = accntBalance;
	}
	public String getAccntHolderName() {
		return accntHolderName;
	}
	public void setAccntHolderName(String accntHolderName) {
		this.accntHolderName = accntHolderName;
	}
}