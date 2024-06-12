package com.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.BookTicket;
import com.entities.Bus;
import com.exception.InvalidBusException;

import com.exception.InvalidTicketException;
import com.repository.BusRepository;
import com.repository.TicketRepository;

@Component
public class TicketDAOImpl implements ITicketDAO{

	//Provide code to Inject TicketRepository
	@Autowired
	private TicketRepository ticketRepository;
	
	//Provide code to Inject BusRepository
	@Autowired
	private BusRepository busRepository;
	
	

	@Override
	public BookTicket addTicket(BookTicket ticket, int busId) throws InvalidBusException {
		//fill code
		Bus bus = busRepository.findById(busId)
				.orElseThrow(() -> new InvalidBusException("Bus not found for id: " + busId));
		ticket.setBusObj(bus);
		return ticketRepository.save(ticket);	
	}
	
	@Override
	public BookTicket viewTicketById(int ticketId) throws InvalidTicketException {
		//fill code		
		BookTicket bookTicket = ticketRepository.findById(ticketId)
				.orElseThrow(() -> new InvalidTicketException("Ticket not found for id: " + ticketId));
		
		return bookTicket;	
	
	}
	
	
	@Override	
	public List<BookTicket> viewTicketInAFareRange(double lowLimit,double highLimit){
		//fill code
		List<BookTicket> bookTickets = ticketRepository.findAll();
		
		return bookTickets.stream()
				.filter(bookTicket -> bookTicket.getBusFare()>= lowLimit && bookTicket.getBusFare()<=highLimit)
				.collect(Collectors.toUnmodifiableList());
		
	}
	
	@Override	
	public List<BookTicket> viewBookingBySource(String source){
		//fill code
		List<BookTicket> bookTickets = ticketRepository.findAll();
		
		return bookTickets.stream()
				.filter(bookTicket -> bookTicket.getBusObj().getSource().equals(source))
				.collect(Collectors.toUnmodifiableList());
		
	}
	
	@Override
	public BookTicket deleteTicket(int ticketId) throws InvalidTicketException {
		//fill code
		BookTicket bookTicket = viewTicketById(ticketId);
		
		ticketRepository.delete(bookTicket);
		ticketRepository.deleteById(ticketId);
		ticketRepository.deleteAllInBatch();
		return bookTicket;
	}
}
