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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.tourguide.model.Trial;
import com.tourguide.service.trial.IntervalTypeService;
import com.tourguide.service.trial.SiteVisitTypeService;
import com.tourguide.service.trial.TrialService;
import com.tourguide.service.trial.VisitTypeService;

@Controller
@RequestMapping("/trial/")
public class TrialController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrialController.class);
	
	
	@Autowired
    private TrialService trialService;
	
	@Autowired
	private IntervalTypeService intervalTypeService;
	
	@Autowired
	private VisitTypeService visitTypeService;
	
	@Autowired
	private SiteVisitTypeService siteVisitTypeService;
 
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
        
        Long selectedIntervalType = trial.getSelectedIntervalType() != null ? trial.getSelectedIntervalType() : 0L;
        trial.setIntervalType(intervalTypeService.getIntervalTypeById(selectedIntervalType));
 
        Long selectedVisitType = trial.getSelectedVisitType() != null ? trial.getSelectedVisitType() : 0L;
        trial.setVisitType(visitTypeService.getVisitTypeById(selectedVisitType));
        
        Long selectedSiteVisitType = trial.getSelectedSiteVisitType() != null ? trial.getSelectedSiteVisitType() : 0L;
        trial.setSiteVisitType(siteVisitTypeService.getSiteVisitTypeById(selectedSiteVisitType));
        
        logger.debug("SelectedIntervalType: {}, selectedVisitType: {}, selectedSiteVisitType: {}", 
        		selectedIntervalType, selectedVisitType, selectedSiteVisitType);
        trialService.save(trial);
        return "redirect:trialDashboard";
    }
    
    
    @GetMapping("/trialDashboard")
    public String openTrialDashboard(@ModelAttribute("trial") @Valid Trial trial, 
    						BindingResult result, Locale locale, Model model) {
        model.addAttribute("trial", trial);
        return "trialDashboard";
    }
    
    
	// show trial
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showTrial(@PathVariable("id") Long id, Model model) {
		logger.debug("showTrial() id: {}", id);

		Trial trial = trialService.getTrialById(id);

		model.addAttribute("trial", trial);

		return "trialDashboard";

	}
    
}
