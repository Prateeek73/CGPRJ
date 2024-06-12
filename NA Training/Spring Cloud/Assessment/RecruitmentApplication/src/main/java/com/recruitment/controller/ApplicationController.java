package com.recruitment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@RestController
public class ApplicationController {

	@GetMapping(value = "/welcome")
	@CircuitBreaker(name = "myCircuitBreaker", fallbackMethod="fallback")
	public String retreiveInfo( ) {
		return "Employee Me Recruitment is a leading recruiter agency and a leading provider of jobs in India.";
		
	}
	
	public String fallback(Exception e) {
		return "Sorry Service is unavailable";
	}
	
}
