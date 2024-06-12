package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ITicketDAO;
import com.entities.BookTicket;
import com.exception.InvalidBusException;
import com.exception.InvalidTicketException;


//Provide necessary Annotation
@Service
public class TicketServiceImpl implements ITicketService{

	
	//Provide necessary Annotation
	@Autowired
	ITicketDAO ticketDAO;
	
	@Override
public  BookTicket addTicket(BookTicket ticket,int busId) throws InvalidBusException{
	//fill the code
		return ticketDAO.addTicket(ticket, busId);
		
	}
	
	@Override
	public BookTicket viewTicketById(int ticketId) throws InvalidTicketException {
		
		//fill code		
		return ticketDAO.viewTicketById(ticketId);	
	}	
	
		

	@Override
	public List<BookTicket> viewBookingBySource(String source)
	{
		return ticketDAO.viewBookingBySource(source);
	}
	
	@Override
	public List<BookTicket> viewTicketInAFareRange(double lowLimit,double highLimit) {
		
		//fill code
		
		return ticketDAO.viewTicketInAFareRange(lowLimit, highLimit);
	}
	
	@Override
	public BookTicket deleteTicket(int ticketId) throws InvalidTicketException {
		
		//fill code
		return ticketDAO.deleteTicket(ticketId);
	}
	
}
