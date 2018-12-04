package com.tourguide.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tourguide.model.IntervalType;
import com.tourguide.model.SiteVisitType;
import com.tourguide.model.Trial;
import com.tourguide.model.TrialVisitDef;
import com.tourguide.model.VisitTreatment;
import com.tourguide.model.VisitType;
import com.tourguide.service.trial.TrialService;
import com.tourguide.service.trial.visit.TrialVisitDefService;

@Controller
@RequestMapping("/trial/")
public class TrialController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrialController.class);
	
	
	@Autowired
    private TrialService trialService;
	
	@Autowired
	private TrialVisitDefService trialVisitDefService;  
 
//    @GetMapping("/")
//    public String trialForm(Locale locale, Model model) {
////        model.addAttribute("patients", patientService.getList());
//        return "addPatient";
//    }
    
    @ModelAttribute("trial")
    public Trial formBackingObject() {
        return new Trial();
    }
    
    @PostMapping(value = "/addTrial")
    public String addTrial(@ModelAttribute("trial") @Valid Trial trial,
    		final BindingResult result, final Model model, final RedirectAttributes redirectAttributes) {
 
        if (result.hasErrors()) {
            return "addTrial";
        }
        
        List<TrialVisitDef> visits = trial.getVisits();
        for(TrialVisitDef visit : visits) {
            Long selectedIntervalType = visit.getSelectedIntervalType() != null ? visit.getSelectedIntervalType() : 0L;
            visit.setIntervalType(trialVisitDefService.getIntervalTypeById(selectedIntervalType));
     
            Long selectedVisitType = visit.getSelectedVisitType() != null ? visit.getSelectedVisitType() : 0L;
            visit.setVisitType(trialVisitDefService.getVisitTypeById(selectedVisitType));
            
            Long selectedSiteVisitType = visit.getSelectedSiteVisitType() != null ? visit.getSelectedSiteVisitType() : 0L;
            visit.setSiteVisitType(trialVisitDefService.getSiteVisitTypeById(selectedSiteVisitType));
            
            logger.debug("Visit: {} SelectedIntervalType: {}, selectedVisitType: {}, selectedSiteVisitType: {} \n", 
            		visit.getTreatment(), selectedIntervalType, selectedVisitType, selectedSiteVisitType);
        }
        
        trialService.save(trial);
        redirectAttributes.addFlashAttribute("trial", trial);
        model.addAttribute("trial", trial);
        return "redirect:trialDashboard";
    }
    
    @RequestMapping(value = "/editVisits", method = RequestMethod.POST)
    public String editVisits(@ModelAttribute("trial") @Valid Trial trial,
    		final BindingResult result, final Model model, final RedirectAttributes redirectAttributes) {
    	
    	List<TrialVisitDef> visits = new ArrayList<TrialVisitDef>();
    	for (int i = 0; i < trial.getNumOfVisits(); i++) {
			visits.add(new TrialVisitDef());
		}
    	trial.setVisits(visits);
    	
        redirectAttributes.addFlashAttribute("trial", trial);
        model.addAttribute("trial", trial);
        
    	List<VisitTreatment> treatmentsList = trialVisitDefService.getTreatmentList();
    	List<VisitType> visitTypeList = trialVisitDefService.getVisitTypeList();
    	List<IntervalType> intervalTypeList = trialVisitDefService.getIntervalTypeList();
    	List<SiteVisitType> siteVisitTypeList = trialVisitDefService.getSiteVisitTypeList();
    	model.addAttribute("treatmentsList", treatmentsList);
    	model.addAttribute("visitTypeList", visitTypeList);
    	model.addAttribute("intervalTypeList", intervalTypeList);
    	model.addAttribute("siteVisitTypeList", siteVisitTypeList);
        
        
        return "addTrial";
    }
    
    
    
    @GetMapping("/trialDashboard")
    public String openTrialDashboard(@ModelAttribute("trial") @Valid Trial trial, 
    		final BindingResult result, final Locale locale, final Model model) {
        model.addAttribute("trial", trial);
        return "trialDashboard";
    }
    
    
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String showTrial(@PathVariable("id") Long id, final Model model) {
		logger.debug("showTrial() id: {}", id);

		Trial trial = trialService.getTrialById(id);
		model.addAttribute("trial", trial);

		return "trialDashboard";

	}
    
}
