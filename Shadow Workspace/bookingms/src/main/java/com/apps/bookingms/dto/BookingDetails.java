package com.apps.bookingms.dto;

public class BookingDetails {

	private Long id;
	private String bookedDateTime;
	private String occupiedDateTime;
	private Double bookingAmount;
	private String releaseDate;
	private PatientDetails patientDetails;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookedDateTime() {
		return bookedDateTime;
	}

	public void setBookedDateTime(String bookedDateTime) {
		this.bookedDateTime = bookedDateTime;
	}

	public String getOccupiedDateTime() {
		return occupiedDateTime;
	}

	public void setOccupiedDateTime(String occupiedDateTime) {
		this.occupiedDateTime = occupiedDateTime;
	}

	public Double getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(Double bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public PatientDetails getPatientDetails() {
		return patientDetails;
	}

	public void setPatientDetails(PatientDetails patientDetails) {
		this.patientDetails = patientDetails;
	}

}

