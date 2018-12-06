package com.tourguide.dao.trial.visit;

import java.util.List;

import com.tourguide.model.TrialTimeUnit;

public interface TrialTimeUnitDao {

	List<TrialTimeUnit> getList();
	
	TrialTimeUnit getByKey(Long id);
}
