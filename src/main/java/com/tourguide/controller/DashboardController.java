package com.tourguide.controller;

import java.util.List;
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

import com.tourguide.model.Patient;
import com.tourguide.model.SiteVisitType;
import com.tourguide.model.Trial;
import com.tourguide.model.TrialTimeUnit;
import com.tourguide.model.VisitTreatment;
import com.tourguide.model.VisitType;
import com.tourguide.service.trial.TrialService;
import com.tourguide.service.trial.visit.TrialVisitDefService;

@Controller
public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	
    @Autowired
    private TrialService trialService;
    
    @Autowired
    private TrialVisitDefService trialVisitDefService;  

    
	
    @GetMapping("/")
    public String dashForm(Locale locale, Model model) {
    	List<Trial> trials = trialService.getList();
    	
        model.addAttribute("trials", trials);
        return "dashboard";
    }
    
    @GetMapping("/gotoAddTrial")
    public String gotoAddTrial(final Locale locale, final Model model) {
    	logger.debug("Loading Add Trial page");
    	List<VisitTreatment> treatmentsList = trialVisitDefService.getTreatmentList();
    	List<VisitType> visitTypeList = trialVisitDefService.getVisitTypeList();
    	List<TrialTimeUnit> trialTimeUnitList = trialVisitDefService.getTrialTimeUnitList();
    	List<SiteVisitType> siteVisitTypeList = trialVisitDefService.getSiteVisitTypeList();
    	
    	model.addAttribute("treatmentsList", treatmentsList);
    	model.addAttribute("visitTypeList", visitTypeList);
    	model.addAttribute("trialTimeUnitList", trialTimeUnitList);
    	model.addAttribute("siteVisitTypeList", siteVisitTypeList);
        return "addTrial";
    }
    
    @GetMapping("/gotoAddPatient")
    public String gotoAddPatient(final Locale locale, final Model model) {
    	logger.debug("Loading Add Patient page");
    	List<Trial> trialList = trialService.getList();
    	
    	model.addAttribute("trialList", trialList);
        return "addPatient";
    }
    
    @ModelAttribute("trial")
    public Trial formBackingObjectTrial() {
        return new Trial();
    }
    
    @ModelAttribute("patient")
    public Patient formBackingObjectPatient() {
        return new Patient();
    }
}
