package com.apps.bookingms.dto;

public class ChangePatientBedRequest {

	private Long patientId;
	private Long bedId;

	public ChangePatientBedRequest(Long patinetId, Long bedId) {
		super();
		this.patientId = patinetId;
		this.bedId = bedId;
	}

	public ChangePatientBedRequest() {
		super();
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

}
