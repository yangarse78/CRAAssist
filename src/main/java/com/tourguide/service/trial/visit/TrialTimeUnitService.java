package com.tourguide.service.trial.visit;

import java.util.List;

import com.tourguide.model.TrialTimeUnit;


public interface TrialTimeUnitService {

	List<TrialTimeUnit> getList();
	
	TrialTimeUnit getTrialTimeUnitById(Long id);
}
