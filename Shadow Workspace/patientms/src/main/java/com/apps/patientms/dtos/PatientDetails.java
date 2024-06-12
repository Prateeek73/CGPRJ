package com.apps.patientms.dtos;

import com.apps.patientms.entity.Address;

public class PatientDetails {
	private Long patientId;
	private String firstName;
	private String lastName;
	private Address patientAddress;
	private BedDetails  bedDetails;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

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

	public Address getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(Address patientAddress) {
		this.patientAddress = patientAddress;
	}

	public BedDetails getBedDetails() {
		return bedDetails;
	}

	public void setBedDetails(BedDetails bedDetails) {
		this.bedDetails = bedDetails;
	}

}
