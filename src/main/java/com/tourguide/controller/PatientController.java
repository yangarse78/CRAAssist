package com.tourguide.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tourguide.model.Patient;
import com.tourguide.service.patient.PatientService;

@Controller
public class PatientController {

	
    @Autowired
    private PatientService patientService;
 
    @GetMapping("/patient")
    public String patientForm(Locale locale, Model model) {
        model.addAttribute("patients", patientService.getList());
        return "addPatient";
    }
    
    @ModelAttribute("patient")
    public Patient formBackingObject() {
        return new Patient();
    }
    
    
}
