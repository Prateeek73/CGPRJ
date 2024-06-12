package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.entities.Bus;
import com.service.IBusService;
import com.exception.InvalidBusException;

//Provide necessary Annotation
@RestController
public class BusController {

	// Provide necessary Annotation
	@Autowired
	IBusService busService;

	// Provide necessary Annotation and fill code
	@PostMapping(value = "/addBus")
	public Bus addBus(@RequestBody Bus bus) {
		return busService.addBus(bus);
	}

	@PutMapping(value = "/updateBusType/{busId}/{busType}")
	public Bus updateBusType(@PathVariable int busId, @PathVariable String busType) throws InvalidBusException {
		return busService.updateBusType(busId, busType);
	}

	@GetMapping(value = "/viewBusBySourceAndDestination/{source}/{destination}")
	public List<Bus> viewBusBySourceAndDestination(@PathVariable String source, @PathVariable String destination) {
		return busService.viewBusBySourceAndDestination(source, destination);
	}

	@GetMapping(value = "/viewBusByBusType/{busType}")
	public List<Bus> viewBusByBusType(@PathVariable String busType) {
		return busService.viewBusByBusType(busType);
	}

}