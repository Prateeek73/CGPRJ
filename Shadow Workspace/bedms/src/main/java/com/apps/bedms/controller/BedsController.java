package com.apps.bedms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apps.bedms.dtos.AddBedRequest;
import com.apps.bedms.dtos.BedDetails;
import com.apps.bedms.dtos.UpdateBedRequest;
import com.apps.bedms.service.IBedService;


@RestController
public class BedsController {
	@Autowired
	private IBedService service;
	
	@PostMapping("/add")
	public BedDetails addBed(@RequestBody AddBedRequest addBedReqest, BindingResult bindingResult) {		
		return service.addBed(addBedReqest);
	}

	@PutMapping("/update")
	public BedDetails updateBed(@RequestBody UpdateBedRequest updateBedReqest, BindingResult bindingResult) {		
		return service.updateBed(updateBedReqest);
	}	
	@GetMapping("/findById/{bedId}")
	public BedDetails getBed(@PathVariable Long bedId) {
		return service.findBedDetailsById(bedId);
	}

//	@Hidden
	@GetMapping("/bookBed/{bedId}")
	public BedDetails bookBed(@PathVariable Long bedId) {
		return service.bookBed(bedId);
	}
	
//	@Hidden
	@GetMapping("/cancelBed/{bedId}")
	public BedDetails cancelBookBed(@PathVariable Long bedId) {
		return service.cancelBookBed(bedId);
	}
	
//	@Hidden
	@GetMapping("/occupyBed/{bedId}")
	public BedDetails occupyBed(@PathVariable Long bedId) {
		return service.occupyBed(bedId);
	}
	
//	@Hidden
	@GetMapping("/unoccupyBed/{bedId}")
	public BedDetails releaseBed(@PathVariable Long bedId) {
		return service.unoccupyBed(bedId);
	}

	@GetMapping("/findBedsByPincode/{pincode}")
	public List<BedDetails> getBedByPinode(@PathVariable Long pincode) {
		return service.findNearByAvailableBeds(pincode);
	}
}
