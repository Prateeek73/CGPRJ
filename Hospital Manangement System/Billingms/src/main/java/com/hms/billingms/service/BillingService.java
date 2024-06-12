package com.hms.billingms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hms.billingms.clients.IBedServiceClient;
import com.hms.billingms.clients.IBookingServiceClient;
import com.hms.billingms.dto.Bed;
import com.hms.billingms.dto.Booking;
import com.hms.billingms.entities.Billing;
import com.hms.billingms.entities.Billing.PaymentStatus;
import com.hms.billingms.exceptions.BillingNotFoundException;
import com.hms.billingms.exceptions.BookingNotFoundException;
import com.hms.billingms.repository.BillingRepository;

@Service
public class BillingService implements IBillingService {

	@Autowired
	private BillingRepository billingRepository;

	@Autowired
	private IBookingServiceClient bookingServiceClient;

	@Autowired
	private IBedServiceClient bedServiceClient;

	@Override
	public Billing generateBill(String authroizationHeader, String bookingId) throws BookingNotFoundException {
		Booking booking = bookingServiceClient.completeBooking(authroizationHeader, bookingId);
		Bed bed = bedServiceClient.makeBedAvaialbe(authroizationHeader, booking.getBedId());
		
		Billing billing = new Billing();
		long differenceInMilliseconds = booking.getReleaseDate().getTime() - booking.getOccupyDate().getTime();
		long differenceInDays = differenceInMilliseconds / (24 * 60 * 60 * 1000);

		billing.setBookingId(bookingId);
		billing.setBillAmount(100 + bed.getCostPerDay()*differenceInDays);
		billing.setPaymentStatus(Billing.PaymentStatus.PENDING);
		
		return addBill(billing);
	}
	
	@Override
	public Billing addBill(Billing billing) {
		return billingRepository.save(billing);
	}

	@Override
	public Billing findById(String billingId) throws BillingNotFoundException {
		return billingRepository.findById(billingId).orElseThrow(() -> new BillingNotFoundException(billingId));
	}

	@Override
	public Billing findByBookingId(String bookingId) throws BookingNotFoundException{
		return billingRepository.findByBookingId(bookingId).orElseThrow(() -> new BookingNotFoundException(bookingId));
	}

	@Override
	public Billing paymentSuccessfull(String billingId) throws BillingNotFoundException {
		Billing billing = findById(billingId);
		billing.setPaymentStatus(PaymentStatus.COMPLETED);
		return billingRepository.save(billing);
	}
}
