package com.tourguide.service.patient;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.patient.PatientDao;
import com.tourguide.model.Patient;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientDao patientDao;  
	
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


	@Override
	public void saveOrUpdate(Patient patient) {
		patientDao.saveOrUpdate(patient);
	}

	
	
	
}
