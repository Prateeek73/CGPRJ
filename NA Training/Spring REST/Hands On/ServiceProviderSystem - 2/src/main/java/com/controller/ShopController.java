package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ProviderService;

@RestController
@RequestMapping("/SPS")
public class ShopController {

	@Autowired
	private ProviderService providerService;

	@PutMapping("/updateConnectionType/{id}/{connectionType}")
	public boolean updateConnectionType(@PathVariable("id") Integer connectionNum,
			@PathVariable("connectionType") String connectionType) {
		return providerService.updateConnectionType(connectionNum, connectionType);
	}

	@DeleteMapping("/deleteConnection/{id}")
	public boolean deleteConnection(@PathVariable("id") Integer connectionNum) {
		return providerService.deleteConnection(connectionNum);
	}

}