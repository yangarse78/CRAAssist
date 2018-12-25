package com.tourguide.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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
import com.tourguide.model.PatientVisit;
import com.tourguide.model.SiteVisitType;
import com.tourguide.model.Trial;
import com.tourguide.model.TrialTimeUnit;
import com.tourguide.model.TrialVisitDef;
import com.tourguide.model.VisitTreatment;
import com.tourguide.model.VisitType;
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
        updatePatientVisits(patient);
        
        patientService.persist(patient);
        redirectAttributes.addFlashAttribute("trial", trial);
        return "redirect:/trial/trialDashboard";
    }

	
	@RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
	public String updateTrial(@PathVariable("id") Long id, final Model model) {
		logger.debug("update Trial() id: {}", id);

		Patient patient = patientService.getPatientById(id);
		patient.setSelectedTrial(patient.getTrial().getId());

		model.addAttribute("patient", patient);
    	List<Trial> trialList = trialService.getList();
    	model.addAttribute("trialList", trialList);
		return "updatePatient";

	}
    
    @RequestMapping(value = "/{id}/updatePatient", method = RequestMethod.POST)
    public String doUpdatePatient(@ModelAttribute("patient") @Valid Patient patient,
                           final BindingResult result, final Model model, final RedirectAttributes redirectAttributes) {
 
        if (result.hasErrors()) {
            return "updatePatient";
        }

        Patient patientBeforeUpdate = patientService.getPatientById(patient.getId());
        if (patientBeforeUpdate.getScreeningDate().compareTo(patient.getScreeningDate()) != 0 || 
        		!patientBeforeUpdate.getTrial().getId().equals(patient.getSelectedTrial())) {
			updatePatientVisits(patient);
		} else {
			patient.setVisits(patientBeforeUpdate.getVisits());
		}
        
        Trial trial = trialService.getTrialById(patient.getSelectedTrial());
        patient.setTrial(trial);
        
		patientService.saveOrUpdate(patient);
        redirectAttributes.addFlashAttribute("patient", patient);
        return "patientDetails";
    }
    
	private void updatePatientVisits(Patient patient) {
		List<TrialVisitDef> defVisitList = patient.getTrial().getVisits();
		List<PatientVisit> visits = new ArrayList<PatientVisit>();
		PatientVisit firstVisit = inializeFirstPatientVisit(patient, patient.getTrial().getFirstVisit());
		
		int firstInterval = firstVisit.getDefVisit().getInterval();
        visits.add(firstVisit);

        //TODO fix - randomization visit to be any of visits
        Date randomization = addDays(firstVisit.getVisitDate(), Math.abs(firstInterval));
        
        //TrialVisitDef randomizationVisitDef = patient.getTrial().getRandomizationVisit();
        for(int i = 1; i < defVisitList.size(); i++) {
        	TrialVisitDef defVisit  = defVisitList.get(i);
        	PatientVisit visit = new PatientVisit();
        	visit.setDefVisit(defVisitList.get(i));
        	visit.setPatient(patient);
        	Date visitDate = addTimeInterval(defVisit, randomization);
        	visit.setVisitDate(visitDate);    
        	Date afterDate = addTimeInterval(defVisit, visitDate);
        	visit.setWindowAfter(afterDate);
        	Date beforeDate = subtractTimeInterval(defVisit, visitDate);
        	visit.setWindowBefore(beforeDate);
        	visits.add(visit);
        }
        patient.setVisits(visits);
	}
    
    private Date addTimeInterval(TrialVisitDef defVisitDef, Date randomizationDate) {
    	int daysToAdd;
    	if(TrialTimeUnitType.WEEKS.equals(defVisitDef.getIntervalType().getId())){
    		daysToAdd = defVisitDef.getInterval()*7;
    	} else {
    		daysToAdd = defVisitDef.getInterval();
    	}
		return addDays(randomizationDate, daysToAdd);
    }
    
    private Date addDays(Date date, int days){
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
    
    private Date subtractTimeInterval(TrialVisitDef defVisitDef, Date lastVisitDate) {
    	int daysToSubtract;
    	if(TrialTimeUnitType.WEEKS.equals(defVisitDef.getIntervalType().getId())){
    		daysToSubtract = defVisitDef.getInterval()*7;
    	} else {
    		daysToSubtract = defVisitDef.getInterval();
    	}
    	daysToSubtract *= -1;
		return addDays(lastVisitDate, daysToSubtract);
    }
   
    
	private PatientVisit inializeFirstPatientVisit(Patient patient, TrialVisitDef trialVisitDef) {
		PatientVisit visit = new PatientVisit();
		visit.setPatient(patient);
		visit.setDefVisit(trialVisitDef);
    	visit.setVisitDate(patient.getScreeningDate());
//    	visit.setWindowBefore(patient.getScreeningDate());
//    	visit.setWindowAfter(patient.getScreeningDate());
    	return visit;
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
