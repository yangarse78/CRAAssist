package com.tourguide.service.patient;

import java.util.List;

import com.tourguide.model.PatientVisit;

public interface PatientVisitService {

	List<PatientVisit> getNearestNotVisitedPatients();

	void updateVisit(PatientVisit visit);

	List<PatientVisit> getScheduledVisits();

	List<PatientVisit> getAllVisits();

}
