package com.service;

import java.util.List;

import com.entities.Bus;
import com.exception.InvalidBusException;

public interface IBusService {
	
	public Bus addBus(Bus bus);
	public Bus updateBusType(int busId, String busType) throws InvalidBusException;
	public List<Bus> viewBusBySourceAndDestination(String source,String destination);
	public List<Bus> viewBusByBusType(String busType);
	
}
