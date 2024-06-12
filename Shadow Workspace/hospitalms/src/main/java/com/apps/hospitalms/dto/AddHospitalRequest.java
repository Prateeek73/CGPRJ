package com.apps.hospitalms.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddHospitalRequest {
	@Length(min = 2, max = 50)
	@NotBlank()
	private String hospitalName;
	@NotBlank()
	@Length(min = 2, max = 20)
	private String city;
	@NotBlank()
	@Length(min = 2, max = 20)
	private String state;
	@NotNull()
	@Min(1)
	@Max(999999)
	private Long pincode;
	@NotBlank()
	private String hospitalType;

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
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

	public String getHospitalType() {
		return hospitalType;
	}

	public void setHospitalType(String hospitalType) {
		this.hospitalType = hospitalType;
	}

	@Override
	public String toString() {
		return "AddHospitalRequest{" + "hospitalName='" + hospitalName + '\'' + ", city='" + city + '\'' + ", state='"
				+ state + '\'' + ", pincode=" + pincode + ", hospitalType='" + hospitalType + '\'' + '}';
	}
}
