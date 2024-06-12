package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import com.spring.model.Appointment;
import com.spring.service.AppointmentService;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping("/showPage")
    public String showPage(@ModelAttribute("appointment") Appointment a) {
        return "showPage";
    }
    
    @PostMapping("/consultation")
    public String bookAppointment(@ModelAttribute("appointment") Appointment appointment, ModelMap model) {
        int charges = service.bookAppointment(appointment);
        model.addAttribute("message", "Thanks for visiting.Your consultation charges is Rs. " + charges);
        return "showPage";
    }


    @ModelAttribute("consultationList")
    public List<String> populateConsultation() {
        return List.of("Optometry", "Psychology", "Pediatrist", "Physical therapy", "Dentistry" );
    }
}