package com.apps.patientms.dtos;

public class BillDetails {
	private BookingDetails bookingDetails;
	private long daysOccupied;
	private double bedCharges;
	private double totalCharges;

	public BookingDetails getBookingDetails() {
		return bookingDetails;
	}

	public void setBookingDetails(BookingDetails bookingDetails) {
		this.bookingDetails = bookingDetails;
	}

	public long getDaysOccupied() {
		return daysOccupied;
	}

	public void setDaysOccupied(long daysOccupied) {
		this.daysOccupied = daysOccupied;
	}

	public double getBedCharges() {
		return bedCharges;
	}

	public void setBedCharges(double bedCharges) {
		this.bedCharges = bedCharges;
	}

	public double getTotalCharges() {
		return totalCharges;
	}

	public void setTotalCharges(double totalCharges) {
		this.totalCharges = totalCharges;
	}

}
