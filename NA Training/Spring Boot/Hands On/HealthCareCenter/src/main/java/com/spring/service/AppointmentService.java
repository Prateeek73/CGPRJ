package com.spring.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.spring.model.Appointment;

@Service
public class AppointmentService {

	public int bookAppointment(Appointment appointment) {
		Map<String, Integer> consultationCharges = new HashMap<>();
		consultationCharges.put("Optometry", 500);
		consultationCharges.put("Psychology", 350);
		consultationCharges.put("Pediatrist", 750);
		consultationCharges.put("Physical therapy", 400);
		consultationCharges.put("Dentistry", 450);
		return consultationCharges.get(appointment.getConsultationFor());
	}
}