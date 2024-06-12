package com.apps.bookingms.util;

import com.apps.bookingms.dto.BedDetails;
import com.apps.bookingms.dto.BillDetails;
import com.apps.bookingms.dto.BookingDetails;
import com.apps.bookingms.dto.ChangePatientBedRequest;
import com.apps.bookingms.dto.PatientDetails;
import com.apps.bookingms.entity.Booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class BookingUtil {
	@Value("${patient.baseUrl}")
	private String basePatientUrl;

	@Value("${bed.baseUrl}")
	private String baseBedUrl;

	@Autowired
	private RestTemplate restTemplate;

	public static LocalDateTime toLocalDateTime(String dateTimeString) {
		dateTimeString = dateTimeString.substring(0, 19);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd'T'HH:mm:ss");
		return LocalDateTime.parse(dateTimeString, formatter);
	}


	public static BookingDetails toBookingDetails(Booking booking, PatientDetails patientDetails) {
		BookingDetails bookingDetails = new BookingDetails();
		bookingDetails.setId(booking.getId());
		bookingDetails.setBookingAmount(booking.getBookingAmount());
		bookingDetails.setBookedDateTime(String.valueOf(booking.getBookedDateTime()));
		bookingDetails.setOccupiedDateTime(String.valueOf(booking.getOccupiedDateTime()));
		bookingDetails.setReleaseDate(String.valueOf(booking.getReleaseDateTime()));
		bookingDetails.setPatientDetails(patientDetails);
		return bookingDetails;
	}

	public PatientDetails getPatientDetails(Long patientId) {
		String url = basePatientUrl + "/findById/" + patientId;
		return restTemplate.getForObject(url, PatientDetails.class);
	}
	
	public BedDetails bookBed(Long bedId) {
		String url = baseBedUrl + "/bookBed/" + bedId;
		return restTemplate.getForObject(url, BedDetails.class);		
	}

	public BedDetails occupyBed(Long bedId) {
		String url = baseBedUrl + "/occupyBed/" + bedId;
		return restTemplate.getForObject(url, BedDetails.class);		
	}

	public BedDetails releaseBed(Long bedId) {
		String url = baseBedUrl + "/unoccupyBed/" + bedId;
		return restTemplate.getForObject(url, BedDetails.class);	
	}
	
	public PatientDetails updatePatientBedId(Long patientId, Long bedId) {
		String url = basePatientUrl + "/changePatientBedId";
		ChangePatientBedRequest changePatientBedRequest = new ChangePatientBedRequest(patientId, bedId);
		HttpEntity<ChangePatientBedRequest> entity = new HttpEntity<>(changePatientBedRequest);
		return restTemplate.exchange(url, HttpMethod.PUT, entity, PatientDetails.class).getBody();	
	}


	public BillDetails generateBill(Booking booking) {
		PatientDetails patientDetails = getPatientDetails(booking.getPatientId());
		BedDetails bedDetails = releaseBed(patientDetails.getBedDetails().getBedId());
		patientDetails.setBedDetails(bedDetails);
		BookingDetails bookingDetails = BookingUtil.toBookingDetails(booking, patientDetails);
		Duration duration = Duration.between(booking.getOccupiedDateTime(), LocalDateTime.now());
		long daysStayed = duration.toDays() + 1;
		BillDetails billDetails = new BillDetails();
		billDetails.setDaysOccupied(daysStayed);
		billDetails.setBookingDetails(bookingDetails);
		billDetails.setBedCharges(daysStayed * patientDetails.getBedDetails().getChargesPerDay());
		billDetails.setTotalCharges(billDetails.getBedCharges() + booking.getBookingAmount());
		return billDetails;
	}
}
