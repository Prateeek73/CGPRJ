package com.service;

import org.springframework.stereotype.Service;

import com.model.Order;

//use appropriate annotation to configure BillService as a Service
@Service
public class BillService {
	
	//calculate the totalCost and return the cost
	public double calculateTotalCost(Order order) {
		double cost=0.0;
		switch(order.getProductName()) {
			case "HeadPhone": cost=450;
				break;
			case "TravelAdapter": cost=1000;
				break;
			case "MemoryCard": cost=300;
				break;
			case "PenDrive": cost=650;
				break;
			case "USBCable": cost=800;
				break;
			default: break;
		}
		cost *= 1.03*order.getQuantity();
		return cost;
	}
}