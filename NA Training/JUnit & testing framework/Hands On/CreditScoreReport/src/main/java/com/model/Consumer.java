package com.model;

public class Consumer{
	private String consumerId;
	private String consumerName;
	private String dateOfBirth;
	private String socialSecurityNumber;
	private double monthlyIncome;
	private int creditScore;
	public Consumer(String consumerId, String consumerName, String dateOfBirth, String socialSecurityNumber,
			double monthlyIncome, int creditScore) {
		super();
		this.consumerId = consumerId;
		this.consumerName = consumerName;
		this.dateOfBirth = dateOfBirth;
		this.socialSecurityNumber = socialSecurityNumber;
		this.monthlyIncome = monthlyIncome;
		this.creditScore = creditScore;
	}
	public String getConsumerId() {
		return consumerId;
	}
	public void setConsumerId(String consumerId) {
		this.consumerId = consumerId;
	}
	public String getConsumerName() {
		return consumerName;
	}
	public void setConsumerName(String consumerName) {
		this.consumerName = consumerName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}	 	  	  	 		  	     	      	 	
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}
	public void setSocialSecurityNumber(String socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}
	public double getMonthlyIncome() {
		return monthlyIncome;
	}
	public void setMonthlyIncome(double monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}
	public int getCreditScore() {
		return creditScore;
	}
	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}
	
		
}
