package com.apps.bookingms.dto;

import java.util.Objects;

public class BedDetails {
	private Long bedId;
	private String bedCategory;
	private String bedStatus;
	private Double chargesPerDay;
	private HospitalDetails hospitalDetails;

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	public String getBedCategory() {
		return bedCategory;
	}

	public void setBedCategory(String bedCategory) {
		this.bedCategory = bedCategory;
	}

	public String getBedStatus() {
		return bedStatus;
	}

	public void setBedStatus(String bedStatus) {
		this.bedStatus = bedStatus;
	}

	public Double getChargesPerDay() {
		return chargesPerDay;
	}

	public void setChargesPerDay(Double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}

	public HospitalDetails getHospitalDetails() {
		return hospitalDetails;
	}

	public void setHospitalDetails(HospitalDetails hospitalDetails) {
		this.hospitalDetails = hospitalDetails;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(bedCategory, bedStatus, hospitalDetails);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BedDetails other = (BedDetails) obj;
		return Objects.equals(bedCategory, other.bedCategory) && Objects.equals(bedStatus, other.bedStatus)
				&& Objects.equals(hospitalDetails, other.hospitalDetails);
	}

	@Override
	public String toString() {
		return "BedDetails [bedId=" + bedId + ", bedCategory=" + bedCategory + ", bedStatus=" + bedStatus
				+ ", chargesPerDay=" + chargesPerDay + ", hospitalDetails=" + hospitalDetails + "]";
	}

}