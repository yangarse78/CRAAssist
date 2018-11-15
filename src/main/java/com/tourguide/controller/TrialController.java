package com.tourguide.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tourguide.model.Trial;
import com.tourguide.service.trial.TrialService;

@Controller
@RequestMapping("/trial/")
public class TrialController {
	
	@Autowired
    private TrialService trialService;
 
    @GetMapping("/")
    public String trialForm(Locale locale, Model model) {
//        model.addAttribute("patients", patientService.getList());
        return "addPatient";
    }
    
    @ModelAttribute("trial")
    public Trial formBackingObject() {
        return new Trial();
    }
    
    @RequestMapping(value = "/addTrial", method = RequestMethod.POST)
    public String addTrial(@ModelAttribute("trial") @Valid Trial trial,
                            BindingResult result, Model model) {
 
        if (result.hasErrors()) {
            return "addTrial";
        }
 
//        trialService.save(trial);
        return "redirect:trialDashboard";
    }
    
    
    @GetMapping("/trialDashboard")
    public String openTrialDashboard(@ModelAttribute("trial") @Valid Trial trial, 
    						BindingResult result, Model model) {
        model.addAttribute("trial", trial);
        return "trialDashboard";
    }
}
