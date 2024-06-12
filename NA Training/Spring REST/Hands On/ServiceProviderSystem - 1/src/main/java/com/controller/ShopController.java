package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Connection;
import com.service.ProviderService;

@RestController
@RequestMapping("/SPS")
public class ShopController {	
	
	@Autowired
	private ProviderService providerService;
	
	@PostMapping("/addConnection")
	public boolean addConnection(@RequestBody Connection connectionObj) {		
		return providerService.addConnection(connectionObj);
	}
	
	@GetMapping("/findConnectionById/{id}")
	public Connection findConnectionById(@PathVariable("id") Integer connectionNum) {
		return providerService.findConnectionById(connectionNum);
	}
	
	@GetMapping("/findAllConnection")
	public List<Connection> findAllConnection() {
		return providerService.viewAllConnections();
	}	
	
}
