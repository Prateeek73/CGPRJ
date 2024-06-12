package com.apps.patientms.service;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.apps.patientms.dtos.AddPatientRequest;
import com.apps.patientms.dtos.BillDetails;
import com.apps.patientms.dtos.PatientDetails;
import com.apps.patientms.dtos.UpdatePatientRequest;

@Validated
public interface IPatientService {

	PatientDetails add(@Valid AddPatientRequest addPatientRequest);

	PatientDetails update(@Valid UpdatePatientRequest requestData);

	PatientDetails findPatientDetailsById(@Min(1) Long patientId);

	BillDetails generateBillById(@Min(1) Long patientId);

	PatientDetails updatePatientBed(@Min(1) Long patientId,@Min(1) Long bedId);

	PatientDetails getBookingDetailsById(@Min(1) Long patientId);

}
