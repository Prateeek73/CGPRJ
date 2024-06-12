package com.hms.billingms.controller;

import com.hms.billingms.dto.BillingRequest;
import com.hms.billingms.dto.PaymentDetails;
import com.hms.billingms.entities.Billing;
import com.hms.billingms.exceptions.BillingNotFoundException;
import com.hms.billingms.service.IBillingService;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import com.razorpay.Order;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/billings")
public class BillingController {

	@Autowired
	private IBillingService billingService;

	@Value("${rzp.key.id}")
	private String KEY_ID;

	@Value("${rzp.key.secret}")
	private String KEY_SECRET;

	@Value("${rzp.currency}")
	private String CURRENCY;

	@PostMapping("/add")
	public Billing addBilling(@RequestHeader("Authorization") String authorizationHeader,
			@RequestBody BillingRequest billingRequest) throws BillingNotFoundException {
		return billingService.generateBill(authorizationHeader, billingRequest.getBookingId());
	}

	@GetMapping("/findById/{billingId}")
	public Billing getBillingById(@PathVariable String billingId) throws BillingNotFoundException {
		return billingService.findById(billingId);
	}

	@GetMapping("/findByBookingId/{bookingId}")
	public Billing getBillingByBookingId(@PathVariable String bookingId) {
		return billingService.findByBookingId(bookingId);
	}

	@GetMapping("/pay/{billingId}")
	public PaymentDetails payment(@PathVariable String billingId) throws RazorpayException, RuntimeException {
		try {
			Billing billing = billingService.findById(billingId);
			if (billing.getPaymentStatus() == Billing.PaymentStatus.COMPLETED) {
				throw new RuntimeException("Billing status is already COMPLETED");
			}

			RazorpayClient razorpay = new RazorpayClient(KEY_ID, KEY_SECRET);
			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount", (billing.getBillAmount())*100);
			orderRequest.put("currency", CURRENCY);
			orderRequest.put("receipt", billing.getId());

			Order order = razorpay.orders.create(orderRequest);
			
			PaymentDetails paymentDetails = new PaymentDetails();
			paymentDetails.setKeyId(KEY_ID);
			paymentDetails.setId(order.get("id"));
			paymentDetails.setAmount(order.get("amount"));
			paymentDetails.setCurrency(order.get("currency"));
			paymentDetails.setBillingId(order.get("receipt"));
			
			return paymentDetails;
		} catch (RazorpayException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@GetMapping("/pay/success/{billingId}")
	public Billing successPay(@PathVariable String billingId) throws BillingNotFoundException{
		return billingService.paymentSuccessfull(billingId);
	}
}