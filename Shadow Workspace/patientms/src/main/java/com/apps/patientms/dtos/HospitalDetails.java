package com.apps.patientms.dtos;

import com.apps.patientms.entity.Address;

public class HospitalDetails {
	private Long hospitalId;
	private String hospitalName;
	private String hospitalType;
	private Address hospitalAddress;

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}

	public Address getHospitalAddress() {
		return hospitalAddress;
	}

	public void setHospitalAddress(Address hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

}
