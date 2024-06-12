package com.apps.bookingms.service;

import org.springframework.validation.annotation.Validated;

import com.apps.bookingms.dto.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@Validated
public interface IBookingService {
	BookingDetails book(@Valid BookingRequest requestData);

	BookingDetails occupyBedByBookingId(@Min(1) Long bookingId);

	BookingDetails findByBookingDetailsById(Long id);

	BookingDetails findByBookingDetailsByPatientId(@Min(1) Long id);

	BillDetails generateBillById(@Min(1) Long bookingId);

	BillDetails generateBillByIdPatientId(Long patientId);

}
