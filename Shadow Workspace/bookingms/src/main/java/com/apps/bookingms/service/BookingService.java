package com.apps.bookingms.service;

import com.apps.bookingms.dto.BedDetails;
import com.apps.bookingms.dto.BillDetails;
import com.apps.bookingms.dto.BookingDetails;
import com.apps.bookingms.dto.BookingRequest;
import com.apps.bookingms.dto.PatientDetails;
import com.apps.bookingms.entity.Booking;
import com.apps.bookingms.exceptions.BookingNotFoundException;
import com.apps.bookingms.repository.IBookingRepository;
import com.apps.bookingms.util.BookingUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;

@Service
public class BookingService implements IBookingService {

	@Autowired
	private BookingUtil util;

	@Autowired
	private IBookingRepository repository;

	public Booking findById(Long id) {
		return repository.findById(id)
				.orElseThrow(() -> new BookingNotFoundException("Booking id not found for : " + id));

	}

	public Booking findBookingByPatientId(@Min(1) Long patientId) {
		List<Booking> bookingList = repository.findBookingByPatientId(patientId);
		if (bookingList.isEmpty())
			throw new BookingNotFoundException("No booking found for patient id : " + patientId);
		return bookingList.get(0);
	}

	@Override
	public BookingDetails book(BookingRequest bookingRequest) {
		List<Booking> bookingList = repository.findBookingByPatientId(bookingRequest.getPatientId());
		Booking booking = bookingList.isEmpty() ? new Booking() : bookingList.get(0);
		booking.setPatientId(bookingRequest.getPatientId());
		booking.setBookingAmount(bookingRequest.getBookingAmount());
		booking.setBookedDateTime(BookingUtil.toLocalDateTime(LocalDateTime.now().toString()));
		booking.setReleaseDateTime(BookingUtil.toLocalDateTime(LocalDateTime.now().toString()).plusDays(14L));

		PatientDetails patientDetails = util.updatePatientBedId(bookingRequest.getPatientId(),
				bookingRequest.getBedId());
		BedDetails bedDetails = util.bookBed(bookingRequest.getBedId());
		patientDetails.setBedDetails(bedDetails);
		return BookingUtil.toBookingDetails(repository.save(booking), patientDetails);
	}

	@Override
	public BookingDetails occupyBedByBookingId(@Min(1) Long bookingId) {
		Booking booking = findById(bookingId);
		booking.setOccupiedDateTime(BookingUtil.toLocalDateTime(LocalDateTime.now().toString()));
		PatientDetails patientDetails = util.getPatientDetails(booking.getPatientId());
		BedDetails bedDetails = util.occupyBed(patientDetails.getBedDetails().getBedId());
		patientDetails.setBedDetails(bedDetails);
		return BookingUtil.toBookingDetails(repository.save(booking), patientDetails);
	}

	@Override
	public BookingDetails findByBookingDetailsById(Long bookingId) {
		Booking booking = findById(bookingId);
		PatientDetails patientDetails = util.getPatientDetails(booking.getPatientId());
		return BookingUtil.toBookingDetails(findById(bookingId), patientDetails);
	}

	@Override
	public BookingDetails findByBookingDetailsByPatientId(Long patientId) {
		return BookingUtil.toBookingDetails(findBookingByPatientId(patientId), util.getPatientDetails(patientId));
	}

	@Override
	public BillDetails generateBillById(Long bookingId) {
		return util.generateBill(findById(bookingId));
	}

	@Override
	public BillDetails generateBillByIdPatientId(Long patientId) {
		return util.generateBill(findBookingByPatientId(patientId));
	}

}
