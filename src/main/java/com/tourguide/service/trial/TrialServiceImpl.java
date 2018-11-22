package com.tourguide.service.trial;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.TrialDao;
import com.tourguide.model.Trial;

@Service
public class TrialServiceImpl implements TrialService{
	
	@Autowired
	private TrialDao trialDao;

	@Transactional
	public List<Trial> getList() {
		return trialDao.getList();
	}

	@Transactional
	public void save(Trial trial) {
		trialDao.save(trial);
	}

	@Transactional
	public Trial getTrialById(Long id) {
		return trialDao.getTrialById(id);
	}
	
	

}
