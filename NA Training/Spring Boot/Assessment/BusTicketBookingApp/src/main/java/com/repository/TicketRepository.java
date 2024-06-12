package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.entities.BookTicket;

public interface TicketRepository extends JpaRepository<BookTicket, Integer>{

	//Provide necessary method to view the Buses based on fare 
	
	//Provide necessary method to view the Buses based on Source
}

