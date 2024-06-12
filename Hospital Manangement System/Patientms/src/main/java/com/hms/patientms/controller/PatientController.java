package com.hms.patientms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hms.patientms.dto.AddPatientRequest;
import com.hms.patientms.entities.Patient;
import com.hms.patientms.exceptions.PatientNotFoundException;
import com.hms.patientms.service.PatientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientService;

	@PostMapping("/add")
	public Patient addPatient(@Valid @RequestBody AddPatientRequest addPatientRequest) {
		return patientService.addPatient(addPatientRequest);
	}

	@PutMapping("/update/{id}")
	public Patient updatePatient(@PathVariable String id, @Valid @RequestBody AddPatientRequest addPatientRequest)
			throws PatientNotFoundException {
		return patientService.updatePatient(id, addPatientRequest);
	}

	@GetMapping("/findById/{id}")
	public Patient findPatient(@PathVariable String id) throws PatientNotFoundException {
		return patientService.findPatientById(id);
	}
}
