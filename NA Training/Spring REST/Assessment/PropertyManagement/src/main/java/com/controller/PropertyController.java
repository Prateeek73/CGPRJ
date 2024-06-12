package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exception.PropertyInvalidException;
import com.model.PropertyInfo;
import com.service.PropertyService;

@RestController
@RequestMapping("/HRE")
public class PropertyController {

	@Autowired
	private PropertyService propertyService;

	@PostMapping("/insertProperty")
	public boolean addProperty(PropertyInfo propertyObj) {
		return propertyService.addProperty(propertyObj);
	}

	@GetMapping("/viewPropertyById/{propertyId}")
	public PropertyInfo viewPropertyById(@PathVariable("propertyId") Integer propertyId) {
		PropertyInfo propertyInfo = propertyService.viewPropertyById(propertyId);
		if (propertyInfo == null) {
			throw new PropertyInvalidException("Property ID " + propertyId + " does not exist");
		}
		return propertyInfo;
	}

	@GetMapping("/viewPropertyByLocationAndCostRange/{location}/{lowLimit}/{highLimit}")
	public ArrayList<PropertyInfo> viewPropertyByLocationAndCostRange(@PathVariable("location") String location,
			@PathVariable("lowLimit") double lowLimit, @PathVariable("highLimit") double highLimit) {
		return propertyService.viewPropertyByLocationAndCostRange(location, lowLimit, highLimit);
	}

	@PutMapping("/updatePropertyStatus/{propertyId}")
	public boolean updatePropertyStatus(@PathVariable("propertyId") Integer propertyId) {
		return propertyService.updatePropertyStatus(propertyId);
	}
	
	@DeleteMapping("/deleteProperty/{propertyId}")
	public boolean deleteProperty(@PathVariable("propertyId") Integer propertyId) {
		return propertyService.deleteProperty(propertyId);
	}

}
