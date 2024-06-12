package com.apps.patientms.service;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.patientms.dtos.AddPatientRequest;
import com.apps.patientms.dtos.BedDetails;
import com.apps.patientms.dtos.BillDetails;
import com.apps.patientms.dtos.PatientDetails;
import com.apps.patientms.dtos.UpdatePatientRequest;
import com.apps.patientms.entity.Address;
import com.apps.patientms.entity.Patient;
import com.apps.patientms.exceptions.PatientNotFoundException;
import com.apps.patientms.repository.IPatientRepository;
import com.apps.patientms.util.PatientUtil;

@Service
public class PatientService implements IPatientService {

	@Autowired
	IPatientRepository patientRepository;

	@Autowired
	PatientUtil putil;

	@Override
	public PatientDetails add(AddPatientRequest addPatientRequest) {
		Patient patient = new Patient();
		patient.setFirstName(addPatientRequest.getFirstName());
		patient.setLastName(addPatientRequest.getLastName());
		patient.setBedId(addPatientRequest.getBedId());
		patient.setAddress(new Address(addPatientRequest.getCity(), addPatientRequest.getState(), addPatientRequest.getPincode()));
		BedDetails bedDetails = putil.bookBed(addPatientRequest.getBedId());
		return PatientUtil.toPatientDetails(patientRepository.save(patient), bedDetails);
	}

	public Patient findPatientById(Long id) {
		return patientRepository.findById(id)
				.orElseThrow(() -> new PatientNotFoundException("Patient not found for id: " + id));
	}

	@Override
	public PatientDetails update(UpdatePatientRequest updatePatientRequest) {
		Patient patient = findPatientById(updatePatientRequest.getPatientId());
		if(!patient.getBedId().equals(updatePatientRequest.getBedId()))
			updatePatientBed(updatePatientRequest.getPatientId(), updatePatientRequest.getBedId());
		patient.setFirstName(updatePatientRequest.getFirstName());
		patient.setLastName(updatePatientRequest.getLastName());
		patient.setBedId(updatePatientRequest.getBedId());
		patient.setAddress(new Address(updatePatientRequest.getCity(), updatePatientRequest.getState(), updatePatientRequest.getPincode()));

		BedDetails bedDetails = putil.bookBed(updatePatientRequest.getBedId());
		return PatientUtil.toPatientDetails(patientRepository.save(patient), bedDetails);
	}

	@Override
	public PatientDetails findPatientDetailsById(Long patientId) {
		Patient patient = findPatientById(patientId);
		BedDetails bedDetails = putil.getBedDetails(patient.getBedId());
		return PatientUtil.toPatientDetails(patient, bedDetails);
	}

	@Override
	public BillDetails generateBillById(Long patientId) {
		return putil.getBillDetails(patientId);
	}

	@Override
	public PatientDetails updatePatientBed(Long patientId, Long bedId) {
		Patient patient = findPatientById(patientId);
		BedDetails bedDetails = putil.cancelBed(patient.getBedId());
		patient.setBedId(bedId);
		return PatientUtil.toPatientDetails(patientRepository.save(patient), bedDetails);
	}

	@Override
	public PatientDetails getBookingDetailsById(@Min(1) Long patientId) {
		return putil.getBookingDetailsByPatientId(patientId);
	}
}
