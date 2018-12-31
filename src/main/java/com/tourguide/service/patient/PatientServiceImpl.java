package com.tourguide.service.patient;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.patient.PatientDao;
import com.tourguide.model.Patient;
import com.tourguide.model.PatientVisit;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao; 
	
	@Autowired
	private PatientVisitService patientVisitService;
	
	@Override
	public List<Patient> getList() {
		// TODOY Auto-generated method stub
		return null;
	}

	
	public List<Patient> getPerTrial(Long id) {
		return patientDao.getPerTrial(id);
	}

	@Transactional
	public void persist(Patient patient) {
		patientDao.persist(patient);
	}

	@Transactional
	public Patient getPatientById(Long id) {
		return patientDao.getByKey(id);
	}

	@Transactional
	public void saveOrUpdate(Patient patient) {
		patientDao.saveOrUpdate(patient);
	}


	public List<PatientVisit> getNearestNotVisitedPatients() {
		return patientVisitService.getNearestNotVisitedPatients();
	}


	@Override
	public void updateVisit(PatientVisit visit) {
		patientVisitService.updateVisit(visit);
	}


	@Override
	public List<PatientVisit> getScheduledVisits() {
		return patientVisitService.getScheduledVisits();
	}


	@Override
	public List<PatientVisit> getAllVisits() {
		return patientVisitService.getAllVisits();
	}

	
	
	
}
