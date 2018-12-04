package com.tourguide.service.trial.visit;

import java.util.List;

import com.tourguide.model.IntervalType;

public interface IntervalTypeService {

	List<IntervalType> getList();
	
	IntervalType getIntervalTypeById(Long id);
}
