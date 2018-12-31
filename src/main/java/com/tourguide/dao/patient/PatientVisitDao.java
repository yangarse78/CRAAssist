package com.tourguide.dao.patient;

import java.util.List;

import com.tourguide.model.PatientVisit;

public interface PatientVisitDao {

	List<PatientVisit> getNearestNotVisitedPatients();

	void update(PatientVisit visit);

	List<PatientVisit> getScheduledVisits();
	
	List<PatientVisit> findAll();
}
