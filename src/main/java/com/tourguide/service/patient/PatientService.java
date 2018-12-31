package com.tourguide.service.patient;

import java.util.List;

import com.tourguide.model.Patient;
import com.tourguide.model.PatientVisit;

public interface PatientService {

	List<Patient> getList();

	List<Patient> getPerTrial(Long id);

	void persist(Patient patient);

	Patient getPatientById(Long id);
	
	void saveOrUpdate(Patient patient);

	List<PatientVisit> getNearestNotVisitedPatients();

	void updateVisit(PatientVisit visit);

	List<PatientVisit> getScheduledVisits();

	List<PatientVisit> getAllVisits();

}
