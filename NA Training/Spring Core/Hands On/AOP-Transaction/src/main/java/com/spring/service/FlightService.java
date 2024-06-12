package com.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.dao.FlightDAO;

@Service
public class FlightService {

	@Autowired
	FlightDAO flightDAO;

	public int bookFlight(Integer flightId, Integer bookId, int noOfBookedSeats) {
		return flightDAO.bookFlight(flightId, bookId, noOfBookedSeats);
	}
}
