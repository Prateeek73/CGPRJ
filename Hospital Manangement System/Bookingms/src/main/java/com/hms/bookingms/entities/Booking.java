package com.hms.bookingms.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "bookings")
public class Booking {
	@Id
	private String id;
	@Indexed
	private String patientId;
	private String hospitalId;
	private String bedId;
	private BedType bedType;
	private Date bookingDate;
	private Date occupyDate;
	private Date releaseDate;
	private BookingStatus bookingStatus;

	public enum BookingStatus {
		REQUESTED, APPROVED, DECLINED, CANCELLED, COMPLETED
	}

	public enum BedType {
		USUAL_BED, ICU_BED, OXYGEN_BED, VENTILATOR_BED
	}
}