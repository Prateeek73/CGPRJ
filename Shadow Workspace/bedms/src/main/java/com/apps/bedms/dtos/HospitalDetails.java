package com.apps.bedms.dtos;

import java.util.Objects;

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
	
	@Override
	public int hashCode() {
		return Objects.hash(hospitalId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HospitalDetails other = (HospitalDetails) obj;
		return Objects.equals(hospitalId, other.hospitalId);
	}

	@Override
	public String toString() {
		return "HospitalDetails [hospitalId=" + hospitalId + ", hospitalName=" + hospitalName + ", hospitalType="
				+ hospitalType + ", hospitalAddress=" + hospitalAddress + "]";
	}

}
