package com.apps.hospitalms.dto;

import javax.validation.constraints.Min;


public class UpdateHospitalRequest extends AddHospitalRequest{
    @Min(1)
    private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
