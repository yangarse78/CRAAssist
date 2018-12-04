package com.tourguide.service.patient;

import java.util.List;

import com.tourguide.model.Patient;

public interface PatientService {

	List<Patient> getList();

	List<Patient> getPerTrial(Long id);

	void save(Patient patient);

	Patient getPatientById(Long id);

}
