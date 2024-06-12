package com.apps.patientms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.apps.patientms.dtos.AddPatientRequest;
import com.apps.patientms.dtos.BillDetails;
import com.apps.patientms.dtos.ChangePatientBedRequest;
import com.apps.patientms.dtos.PatientDetails;
import com.apps.patientms.dtos.UpdatePatientRequest;
import com.apps.patientms.service.IPatientService;

@RestController
public class PatientController {
	@Autowired
	private IPatientService service;

	@PostMapping("/add")
	public PatientDetails addPatient(@RequestBody AddPatientRequest addPatientRequest, BindingResult result) {
		return service.add(addPatientRequest);
	}

	@PutMapping("/update")
	public PatientDetails updatePatient(@RequestBody UpdatePatientRequest updatePatientDeatails) {
		return service.update(updatePatientDeatails);
	}

	@GetMapping("/findById/{patientId}")
	public PatientDetails findPatient(@PathVariable Long patientId) {
		return service.findPatientDetailsById(patientId);
	}

	@PutMapping("/changePatientBedId")
	public PatientDetails updatePatientBed(@Valid @RequestBody ChangePatientBedRequest changePatientBedRequest ){
		return service.updatePatientBed(changePatientBedRequest.getPatientId(), changePatientBedRequest.getBedId());
	}

	@GetMapping("/getBillById/{patientId}")
	public PatientDetails getBookinDetailsById(@PathVariable Long patientId) {
		return service.getBookingDetailsById(patientId);
	}

	@GetMapping("/generateBillById/{patientId}")
	public BillDetails generateBillById(@PathVariable Long patientId) {
		return service.generateBillById(patientId);
	}

}

