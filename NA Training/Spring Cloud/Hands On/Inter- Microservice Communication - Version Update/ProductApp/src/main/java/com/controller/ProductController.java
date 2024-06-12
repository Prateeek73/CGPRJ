package com.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	@GetMapping(value = "/getDetails")
	public String getProdctDetails() {
		return " This is product application";
	}

}
