package com.tourguide.dao.patient;

import java.util.List;

import com.tourguide.model.Patient;

public interface PatientDao {

	List<Patient> getList();

	List<Patient> getPerTrial(Long id);

	void persist(Patient patient);

	Patient getByKey(Long id);

	void saveOrUpdate(Patient patient);
	
}
