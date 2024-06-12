package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.BookTicket;
import com.exception.InvalidTicketException;
import com.exception.InvalidBusException;
import com.service.ITicketService;

//Provide necessary Annotation
@RestController
public class TicketController {

	// Provide necessary Annotation
	@Autowired
	ITicketService ticketService;

	// Provide necessary Annotation and fill code
	@PostMapping(value = "/addTicket/{busId}")
	public BookTicket addTicket(@RequestBody BookTicket ticket, @PathVariable int busId) throws InvalidBusException {
		return ticketService.addTicket(ticket, busId);
	}

	@GetMapping(value = "/viewTicketById/{ticketId}")
	public BookTicket viewTicketById(@PathVariable int ticketId) throws InvalidTicketException {
		return ticketService.viewTicketById(ticketId);
	}

	@GetMapping(value = "/viewBookingBySource/{source}")
	public List<BookTicket> viewBookingBySource(@PathVariable String source) {
		return ticketService.viewBookingBySource(source);
	}

	@GetMapping(value = "/viewTicketByFare/{lowLimit}/{highLimit}")
	public List<BookTicket> viewTicketInAFareRange(@PathVariable double lowLimit, @PathVariable double highLimit) {
		return ticketService.viewTicketInAFareRange(lowLimit, highLimit);
	}

	@DeleteMapping(value = "/deleteTicket/{ticketId}")
	public BookTicket deleteTicket(@PathVariable int ticketId) throws InvalidTicketException {
		return ticketService.deleteTicket(ticketId);
	}

}
