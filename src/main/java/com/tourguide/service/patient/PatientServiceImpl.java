package com.tourguide.service.patient;

import java.util.List;

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

	
	
	
}
