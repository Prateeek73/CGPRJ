package com.bean;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class ATMCard {

	@Id
	private String cardNumber;
	private String cardType;
	@Temporal(TemporalType.DATE)
	private Date expiryDate;
	private int cvvNumber;

	@OneToOne
	@JoinColumn(unique = true)
	private Account account;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public int getCvvNumber() {
		return cvvNumber;
	}

	public void setCvvNumber(int cvvNumber) {
		this.cvvNumber = cvvNumber;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
