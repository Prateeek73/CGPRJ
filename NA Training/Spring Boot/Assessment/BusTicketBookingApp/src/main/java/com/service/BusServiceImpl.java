package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IBusDAO;
import com.entities.Bus;

import com.exception.InvalidBusException;

//Provide necessary Annotation
@Service
public class BusServiceImpl implements IBusService{
	
	//Provide necessary Annotation
	@Autowired
	IBusDAO busDAO;

	@Override
	public Bus addBus(Bus bus) {
		
		//fill code
		
		return busDAO.addBus(bus);
	
	}
	
	@Override
	public Bus updateBusType(int busId, String busType) throws InvalidBusException {

		
		//fill code
		
		return busDAO.updateBusType(busId, busType);
	}
	
	
	
	@Override
	public List<Bus> viewBusBySourceAndDestination(String source,String destination) {
		
		//fill code
		
		return busDAO.viewBusBySourceAndDestination(source, destination);
	
	}
	
	@Override
	public List<Bus> viewBusByBusType(String busType) {
		
		//fill code
		
		return busDAO.viewBusByBusType(busType);
	
	}

}
