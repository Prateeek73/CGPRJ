package com.apps.bookingms.entity;

import javax.persistence.*;

import java.time.LocalDateTime;

@Table(name = "bookings")
@Entity
public class Booking {

	@GeneratedValue
	@Id
	private Long id;
	@Column(nullable = false)
	private Long patientId;
	@Column(nullable = false)
	private Double bookingAmount;
	@Column(nullable = false)
	private LocalDateTime bookedDateTime;

	public LocalDateTime getReleaseDateTime() {
		return releaseDateTime;
	}

	public void setReleaseDateTime(LocalDateTime releaseDateTime) {
		this.releaseDateTime = releaseDateTime;
	}

	private LocalDateTime occupiedDateTime;
	private LocalDateTime releaseDateTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public LocalDateTime getBookedDateTime() {
		return bookedDateTime;
	}

	public void setBookedDateTime(LocalDateTime bookedDateTime) {
		this.bookedDateTime = bookedDateTime;
	}

	public LocalDateTime getOccupiedDateTime() {
		return occupiedDateTime;
	}

	public void setOccupiedDateTime(LocalDateTime occupiedDateTime) {
		this.occupiedDateTime = occupiedDateTime;
	}

	public Double getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(Double bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Booking booking = (Booking) o;

		return id.equals(booking.id);
	}

	@Override
	public int hashCode() {
		return id.hashCode();
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", patientId=" + patientId + ", bookedDateTime=" + bookedDateTime
				+ ", occupiedDateTime=" + occupiedDateTime + ", bookingAmount=" + bookingAmount + "]";
	}
}