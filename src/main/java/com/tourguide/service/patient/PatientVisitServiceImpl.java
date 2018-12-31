package com.tourguide.service.patient;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.patient.PatientVisitDao;
import com.tourguide.model.PatientVisit;

@Service
public class PatientVisitServiceImpl implements PatientVisitService{

	@Autowired
	private PatientVisitDao dao;
	
	@Override
	public List<PatientVisit> getNearestNotVisitedPatients() {
		return dao.getNearestNotVisitedPatients();
	}

	@Transactional
	@Override
	public void updateVisit(PatientVisit visit) {
		dao.update(visit);
	}

	@Override
	public List<PatientVisit> getScheduledVisits() {
		return dao.getScheduledVisits();
	}

	@Override
	public List<PatientVisit> getAllVisits() {
		return dao.findAll();
	}

}
