package com.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sales.proxy.ServiceProxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
public class ApplicationController {

	@Autowired
	private ServiceProxy proxy;

	@GetMapping(value = "/accessApp")
	public String retreiveInfo() {
		return proxy.getDetails();
	}

}
