package com.dao;

import java.util.List;

import com.entities.BookTicket;
import com.exception.InvalidBusException;
import com.exception.InvalidTicketException;

public interface ITicketDAO {

	public  BookTicket addTicket(BookTicket ticket, int busId) throws InvalidBusException;
	public BookTicket viewTicketById(int ticketId) throws InvalidTicketException;
	public List<BookTicket> viewBookingBySource(String source);
	public List<BookTicket> viewTicketInAFareRange(double lowLimit,double highLimit);
	public BookTicket deleteTicket(int ticketId) throws InvalidTicketException ;
}
