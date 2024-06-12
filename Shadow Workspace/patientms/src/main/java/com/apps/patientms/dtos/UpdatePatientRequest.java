package com.apps.patientms.dtos;

import javax.validation.constraints.Min;

public class UpdatePatientRequest extends AddPatientRequest {
	@Min(1)
	private Long patientId;

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

}