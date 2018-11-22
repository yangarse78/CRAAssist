package com.tourguide.controller;

import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.tourguide.model.IntervalType;
import com.tourguide.model.SiteVisitType;
import com.tourguide.model.Trial;
import com.tourguide.model.VisitType;
import com.tourguide.service.patient.PatientService;
import com.tourguide.service.trial.IntervalTypeService;
import com.tourguide.service.trial.SiteVisitTypeService;
import com.tourguide.service.trial.TrialService;
import com.tourguide.service.trial.VisitTypeService;

@Controller
public class DashboardController {

	private static final Logger logger = LoggerFactory.getLogger(DashboardController.class);
	
	
    @Autowired
    private TrialService trialService;
    
    @Autowired
    private VisitTypeService visitTypeService;
    
    @Autowired
    private IntervalTypeService intervalTypeService;
    
    @Autowired
    private SiteVisitTypeService siteVisitTypeService; 
    
	
    @GetMapping("/")
    public String dashForm(Locale locale, Model model) {
    	List<Trial> trials = trialService.getList();
    	
        model.addAttribute("trials", trials);
        return "dashboard";
    }
    
    @GetMapping("/gotoAddTrial")
    public String gotoAddTrial(Locale locale, Model model) {
    	logger.debug("Loading Add Trial page");
    	List<VisitType> visitTypeList = visitTypeService.getList();
    	List<IntervalType> intervalTypeList = intervalTypeService.getList();
    	List<SiteVisitType> siteVisitTypeList = siteVisitTypeService.getList();
    	
    	model.addAttribute("visitTypeList", visitTypeList);
    	model.addAttribute("intervalTypeList", intervalTypeList);
    	model.addAttribute("siteVisitTypeList", siteVisitTypeList);
        return "addTrial";
    }
    
    @ModelAttribute("trial")
    public Trial formBackingObject() {
        return new Trial();
    }
}
