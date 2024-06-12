package com.apps.bedms.dtos;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class AddBedRequest {
	@NotBlank()
	@Length(min = 7, max = 14)
	private String bedCategory;
	@NotNull()
	@Min(value = 1)
	private double chargesPerDay;
	@NotNull()
	@Min(value = 1)
	private Long hospitalId;

	public String getBedCategory() {
		return bedCategory;
	}

	public void setBedCategory(String bedCategory) {
		this.bedCategory = bedCategory;
	}

	public double getChargesPerDay() {
		return chargesPerDay;
	}

	public void setChargesPerDay(double chargesPerDay) {
		this.chargesPerDay = chargesPerDay;
	}

	public Long getHospitalId() {
		return hospitalId;
	}

	public void setHospitalId(Long hospitalId) {
		this.hospitalId = hospitalId;
	}

	@Override
	public String toString() {
		return "AddBedRequest [bedCategory=" + bedCategory + ", chargesPerDay=" + chargesPerDay + ", hospitalId="
				+ hospitalId + "]";
	}

}
