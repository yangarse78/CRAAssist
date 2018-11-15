package com.tourguide.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.tourguide.service.patient.PatientService;

@Controller
public class DashboardController {

    @Autowired
    private PatientService patientService;
	
    @GetMapping("/")
    public String patientForm(Locale locale, Model model) {
        model.addAttribute("patients", patientService.getList());
        return "dashboard";
    }
}
