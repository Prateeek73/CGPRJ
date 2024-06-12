package com.model;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class Candidate {
	@NotBlank(message = "Name cannot be blank")
	@Pattern(regexp = "^[a-zA-Z\\\\s]{3,10}$", message = "Name should contain only alphabets and space min 3 chars and max 10 chars")
	private String candidateName;
	
	@NotBlank(message = "Contact number should not be blank")
	@Pattern(regexp = "^[6-9]\\\\d{9}$", message = "Contact Number should be of 10 digits/Contact Number should start with range 6 to 9")
	private String contactNumber;
	private char gender;
	private String positionApplied;
	
	@DecimalMin(value = "10000", message = "must be greater than or equal to 100000")
	@DecimalMax(value = "200000", message = "must be less than or equal to 200000")
	private double expectedSalary;
	
	@DecimalMin(value = "1", message = "must be greater than or equal to 0")
	private int yearsOfExperience;

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getPositionApplied() {
		return positionApplied;
	}

	public void setPositionApplied(String positionApplied) {
		this.positionApplied = positionApplied;
	}

	public double getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public int getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(int yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}
}
