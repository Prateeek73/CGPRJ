package com.apps.patientms.util;

import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.apps.patientms.dtos.BedDetails;
import com.apps.patientms.dtos.BillDetails;
import com.apps.patientms.dtos.PatientDetails;
import com.apps.patientms.entity.Patient;

@Component
public class PatientUtil {

	@Value("${bed.baseUrl}")
	private String baseBedUrl;

	@Value("${booking.baseUrl}")
	private String baseBookingUrl;
	@Autowired
	private RestTemplate restTemplate;

	public static PatientDetails toPatientDetails(Patient patient, BedDetails bedDetails) {
		PatientDetails patientDetails = new PatientDetails();
		patientDetails.setPatientId(patient.getId());
		patientDetails.setFirstName(patient.getFirstName());
		patientDetails.setLastName(patient.getLastName());
		patientDetails.setPatientAddress(patient.getAddress());
		patientDetails.setBedDetails(bedDetails);
		return patientDetails;
	}

	public BedDetails bookBed(Long bedId) {
		String url = baseBedUrl + "/bookBed/" + bedId;
		return restTemplate.getForObject(url, BedDetails.class);
	}

	public BedDetails cancelBed(Long bedId) {
		String url = baseBedUrl + "/cancelBed/" + bedId;
		return restTemplate.getForObject(url, BedDetails.class);
	}

	public BedDetails getBedDetails(Long bedId) {
		String url = baseBedUrl + "/findById/" + bedId;
		return restTemplate.getForObject(url, BedDetails.class);
	}

	public BedDetails unoccupyBed(Long bedId) {
		String url = baseBedUrl + "/unoccupyBed/" + bedId;
		return restTemplate.getForObject(url, BedDetails.class);
	}

	public BillDetails getBillDetails(Long patientId) {
		String url = baseBookingUrl + "/generateBillByPatientId/" + patientId;
		return restTemplate.getForObject(url, BillDetails.class);

	}

	public PatientDetails getBookingDetailsByPatientId(@Min(1) Long patientId) {
		String url = baseBookingUrl + "/findByPatientId/" + patientId;
		return restTemplate.getForObject(url, PatientDetails.class);
	}

}
