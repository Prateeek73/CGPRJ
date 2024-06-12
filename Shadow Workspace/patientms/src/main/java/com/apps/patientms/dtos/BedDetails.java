package com.apps.patientms.dtos;

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
}