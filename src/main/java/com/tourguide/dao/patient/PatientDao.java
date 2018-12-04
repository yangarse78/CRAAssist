package com.tourguide.dao.patient;

import java.util.List;

import com.tourguide.model.Patient;

public interface PatientDao {

	List<Patient> getList();

	List<Patient> getPerTrial(Long id);

	void save(Patient patient);

	Patient getPatientById(Long id);
	
}
