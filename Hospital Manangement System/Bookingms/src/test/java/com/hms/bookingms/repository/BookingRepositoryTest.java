package com.hms.bookingms.repository;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import com.hms.bookingms.entities.Booking;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@DataMongoTest
public class BookingRepositoryTest {

	@Mock
	private BookingRepository bookingRepository;

	@Test
	public void testSaveBooking() {
		// Arrange
		Booking testBooking = new Booking();
		testBooking.setPatientId("patientId");
		testBooking.setHospitalId("hospitalId");
		testBooking.setBedId("bedId");
		testBooking.setBedType(Booking.BedType.USUAL_BED);
		testBooking.setBookingDate(new Date());
		testBooking.setOccupyDate(new Date());
		testBooking.setReleaseDate(new Date());
		testBooking.setBookingStatus(Booking.BookingStatus.REQUESTED);

		// Mock
		when(bookingRepository.save(testBooking)).thenReturn(testBooking);

		// Act
		Booking savedBooking = bookingRepository.save(testBooking);

		// Assert
		assertEquals(testBooking, savedBooking);
	}

	@Test
	public void testFindAllByPatientId() {
		// Arrange
		Booking testBooking = new Booking();
		testBooking.setPatientId("patientId");
		testBooking.setHospitalId("hospitalId");
		testBooking.setBedId("bedId");
		testBooking.setBedType(Booking.BedType.USUAL_BED);
		testBooking.setBookingDate(new Date());
		testBooking.setOccupyDate(new Date());
		testBooking.setReleaseDate(new Date());
		testBooking.setBookingStatus(Booking.BookingStatus.REQUESTED);

		// Mock
		when(bookingRepository.findAllByPatientId("patientId")).thenReturn(List.of(testBooking));

		// Act
		List<Booking> bookings = bookingRepository.findAllByPatientId("patientId");

		// Assert
		assertEquals(1, bookings.size());
		assertEquals(testBooking, bookings.get(0));
	}

	@Test
	public void testFindAllByHospitalId() {
		// Arrange
		Booking testBooking = new Booking();
		testBooking.setPatientId("patientId");
		testBooking.setHospitalId("hospitalId");
		testBooking.setBedId("bedId");
		testBooking.setBedType(Booking.BedType.USUAL_BED);
		testBooking.setBookingDate(new Date());
		testBooking.setOccupyDate(new Date());
		testBooking.setReleaseDate(new Date());
		testBooking.setBookingStatus(Booking.BookingStatus.REQUESTED);

		// Mock
		when(bookingRepository.findAllByHospitalId("hospitalId")).thenReturn(List.of(testBooking));

		// Act
		List<Booking> bookings = bookingRepository.findAllByHospitalId("hospitalId");

		// Assert
		assertEquals(1, bookings.size());
		assertEquals(testBooking, bookings.get(0));
	}
}