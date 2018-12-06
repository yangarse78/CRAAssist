package com.tourguide.service.trial.visit;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.visit.TrialTimeUnitDao;
import com.tourguide.model.TrialTimeUnit;

@Service
public class TrialTimeUnitServiceImpl implements TrialTimeUnitService {

	@Autowired
	private TrialTimeUnitDao trialTimeUnitDao;
	
	@Transactional	
	public List<TrialTimeUnit> getList() {
		return trialTimeUnitDao.getList();
	}

	@Transactional
	public TrialTimeUnit getTrialTimeUnitById(Long id) {
		return trialTimeUnitDao.getByKey(id);
	}

	
	
}
