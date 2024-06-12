package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entities.Bus;

//Provide necessary Annotation
public interface BusRepository extends JpaRepository<Bus, Integer>{
	
	//Provide necessary method to view Buses based on Source and Destination
	List<Bus> findBusBySourceAndDestination(String source, String destination);
	
	//Provide necessary method to view Buses based on Bus Type (AC / NonAC)
	List<Bus> findBusByBusType(String busType);
}


