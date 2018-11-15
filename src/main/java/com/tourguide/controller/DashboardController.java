package com.tourguide.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tourguide.model.Trial;
import com.tourguide.service.patient.PatientService;

@Controller
public class DashboardController {

    @Autowired
    private PatientService patientService;
	
    @GetMapping("/")
    public String dashForm(Locale locale, Model model) {
//        model.addAttribute("patients", patientService.getList());
        return "dashboard";
    }
    
    @GetMapping("/gotoAddTrial")
    public String gotoAddTrial(Locale locale, Model model) {
        return "addTrial";
    }
    
    @ModelAttribute("trial")
    public Trial formBackingObject() {
        return new Trial();
    }
}
