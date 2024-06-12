package com.hms.billingms.service;

import com.hms.billingms.entities.Billing;
import com.hms.billingms.exceptions.BillingNotFoundException;
import com.hms.billingms.exceptions.BookingNotFoundException;

public interface IBillingService {
	Billing generateBill(String authroizationHeader, String bookingId) throws BookingNotFoundException, BookingNotFoundException;
	Billing findById(String billingId) throws BillingNotFoundException;
	Billing findByBookingId(String bookingId) throws BookingNotFoundException;
	Billing addBill(Billing billing);
	Billing paymentSuccessfull(String billingId) throws BillingNotFoundException;
}