package com.apps.patientms.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


public class AddPatientRequest {
	@NotBlank
	@Length(min = 2, max = 10)
	private String firstName;
	@NotBlank
	@Length(min = 2, max = 10)
	private String lastName;
	@NotNull
	@Min(1)
	private Long bedId;
	@NotBlank
	@Length(min = 2, max = 10)
	private String city;
	@Length(min = 2, max = 20)
	@NotBlank
	private String state;
	@NotNull
	@Min(1)
	@Max(999999)
	private Long pincode;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}
}
