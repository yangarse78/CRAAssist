package com.tourguide.service.trial;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.TrialDao;
import com.tourguide.model.Trial;
import com.tourguide.service.patient.PatientService;
import com.tourguide.service.trial.visit.TrialVisitDefService;

@Service
public class TrialServiceImpl implements TrialService{
	
	@Autowired
	private TrialDao trialDao;

	@Autowired
	private PatientService patientService;
	
	@Autowired
	private TrialVisitDefService trialVisitDefService;

	@Transactional
	public List<Trial> getList() {
		List<Trial>list = trialDao.getList();
		for(Trial t : list) {
			t.setTrialFullName(t.getTrialNum() + " - " + t.getName());
		}
		return list;
	}

	@Transactional
	public void persist(Trial trial) {
		trialDao.persist(trial);
	}
	
	@Transactional
	public void save(Trial trial) {
		trialDao.persist(trial);
	}
	
	@Transactional
	public void saveOrUpdate(Trial trial) {
		trialDao.saveOrUpdate(trial);
	}

	@Transactional
	public Trial getTrialById(Long id) {
		Trial trial = trialDao.getByKey(id);
		trial.setPatients(patientService.getPerTrial(id));
		trial.setVisits(trialVisitDefService.getPerTrial(id));
		return trial;
	}




	
	

}
