package com.recruitment.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	
	@GetMapping(value="/welcome")
	public @ResponseBody String greeting( ) {
		
		return "Employee Me Recruitment is a leading recruiter agency and a leading provider of jobs in India.";
		
	}
}
