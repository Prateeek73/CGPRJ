package com.dao;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Bus;
import com.exception.InvalidBusException;
import com.repository.BusRepository;

@Component
public class BusDAOImpl implements IBusDAO{
	
	//Provide code to Inject AccountRepository
	@Autowired
	private BusRepository busRepository;
	
	@Override
	public Bus addBus(Bus bus) {
		//fill code
		return busRepository.save(bus);	
	}
	
	@Override
	public Bus updateBusType(int busId, String busType) throws InvalidBusException {
		//fill code
		Bus bus = busRepository.findById(busId)
				.orElseThrow(() -> new InvalidBusException("Bus not found for id: " + busId));
		bus.setBusType(busType);
		return busRepository.save(bus);
	}


	@Override
	public List<Bus> viewBusBySourceAndDestination(String source,String destination) {
		//fill code
//		List<Bus> buses = busRepository.findAll();
//		
//		return buses.stream()
//				.filter(bus -> bus.getSource().equals(source) && bus.getDestination().equals(destination))
//				.collect(Collectors.toUnmodifiableList());
		
		return busRepository.findBusBySourceAndDestination(source, destination);
	
	}
	@Override
	public List<Bus> viewBusByBusType(String busType) {
		//fill code
//		List<Bus> buses = busRepository.findAll();
//		
//		return buses.stream()
//				.filter(bus -> bus.getBusType().equals(busType))
//				.collect(Collectors.toUnmodifiableList());	
		
		return busRepository.findBusByBusType(busType);
	}
}