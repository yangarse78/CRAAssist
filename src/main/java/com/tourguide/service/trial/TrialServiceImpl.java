package com.tourguide.service.trial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.TrialDao;

@Service
public class TrialServiceImpl implements TrialService{
	
	@Autowired
	private TrialDao trialDao;
	
	

}
