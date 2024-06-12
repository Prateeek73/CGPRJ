package com.apps.hospitalms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apps.hospitalms.dto.AddHospitalRequest;
import com.apps.hospitalms.dto.HospitalDetails;
import com.apps.hospitalms.dto.UpdateHospitalRequest;
import com.apps.hospitalms.service.IHospitalService;

import java.util.List;

@RestController
public class HospitalController {

	@Autowired
	private IHospitalService service;

	@PostMapping("/add")
	public ResponseEntity<HospitalDetails> add(@RequestBody AddHospitalRequest request, BindingResult bindingResult) {
		return new ResponseEntity<>(service.add(request), HttpStatus.OK);
	}

	@GetMapping("/findById/{id}")
	public HospitalDetails findById(@PathVariable Long id) {
		return service.findHospitalDetailsById(id);
	}

	@PutMapping("/update")
	public HospitalDetails update(@RequestBody UpdateHospitalRequest request, BindingResult bindingResult) {
		return service.update(request);
	}

	@GetMapping("/findNearByHospital/{pincode}")
	public List<HospitalDetails> findNearByHospitals(@PathVariable Long pincode) {
		return service.findNearByHospitals(pincode);
	}
}
