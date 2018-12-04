package com.tourguide.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tourguide.model.Patient;
import com.tourguide.model.Trial;
import com.tourguide.service.patient.PatientService;
import com.tourguide.service.trial.TrialService;

@Controller
@RequestMapping("/patient/")
public class PatientController {

	private static final Logger logger = LoggerFactory.getLogger(PatientController.class);
	
    @Autowired
    private PatientService patientService;
    
    @Autowired
    private TrialService trialService;
 
    @GetMapping("/patient")
    public String patientForm(final Locale locale, final Model model) {
        model.addAttribute("patients", patientService.getList());
        return "addPatient";
    }
    
    @ModelAttribute("patient")
    public Patient formBackingObject() {
        return new Patient();
    }
    
    @RequestMapping(value = "/addPatient", method = RequestMethod.POST)
    public String addPatient(@ModelAttribute("patient") @Valid Patient patient,
                           final BindingResult result, final Model model, final RedirectAttributes redirectAttributes) {
 
        if (result.hasErrors()) {
            return "addPatient";
        }
        
        Trial trial = trialService.getTrialById(patient.getSelectedTrial());
        patient.setTrial(trial);
        
        patientService.save(patient);
        redirectAttributes.addFlashAttribute("trial", trial);
        return "redirect:/trial/trialDashboard";
    }
    
    @GetMapping("/patientlDashboard")
    public String openPatientDashboard(@ModelAttribute("patient") @Valid Patient patient, 
    		final BindingResult result, final Locale locale, final Model model) {
        model.addAttribute("patient", patient);
        return "patientlDashboard";
    }
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showPatient(@PathVariable("id") Long id, Model model) {
		logger.debug("showPatient() id: {}", id);

		Patient patient = patientService.getPatientById(id);
		model.addAttribute("patient", patient);

		return "patientDetails";

	}
}
