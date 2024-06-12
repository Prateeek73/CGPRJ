package com.apps.bookingms.controller;

import com.apps.bookingms.dto.BillDetails;
import com.apps.bookingms.dto.BookingDetails;
import com.apps.bookingms.dto.BookingRequest;
import com.apps.bookingms.service.IBookingService;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookingController {

	@Autowired
	private IBookingService service;

	@PostMapping("/book")
	public BookingDetails book(@Valid @RequestBody BookingRequest addBookingRequest) {
		return service.book(addBookingRequest);
	}
	
	@GetMapping("/occupyBooking/{bookingId}")
	public BookingDetails occupyBed(@Min(1) @PathVariable Long bookingId) {
		return service.occupyBedByBookingId(bookingId);
	}
	
	@GetMapping("/findById/{bookingId}")
	public BookingDetails bookingDetailsById(@PathVariable Long bookingId) {
		return service.findByBookingDetailsById(bookingId);
	}
	
	@GetMapping("/findByPatientId/{patientId}")
	public BookingDetails bookingDetailsByPatientId(@PathVariable Long patientId) {
		return service.findByBookingDetailsByPatientId(patientId);
	}

	@GetMapping("/generateBillById/{bookingId}")
	public BillDetails generateBillById(@PathVariable Long bookingId) {
		return service.generateBillById(bookingId);
	}
	
	@GetMapping("/generateBillByPatientId/{patientId}")
	public BillDetails generateBillByPatientId(@PathVariable Long patienttId) {
		return service.generateBillByIdPatientId(patienttId);
	}
}
