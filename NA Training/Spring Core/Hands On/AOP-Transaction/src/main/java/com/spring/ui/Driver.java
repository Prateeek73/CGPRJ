package com.spring.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.service.FlightService;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		FlightService flightService = (FlightService) context.getBean("flightService");
		System.out.println(flightService.bookFlight(2000, 1, 30));
	}
}
