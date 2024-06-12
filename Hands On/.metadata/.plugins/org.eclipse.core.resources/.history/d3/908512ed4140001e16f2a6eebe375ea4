package com.controller;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/myapp")
public class UserController {
	

	
	@GetMapping("/user")
	public String userDetails() {
		return "You have accessed the user details.";
	}



	@GetMapping("/admin")
	public String adminDetails() {
		return "You have accessed the admin details.";
	}
}
