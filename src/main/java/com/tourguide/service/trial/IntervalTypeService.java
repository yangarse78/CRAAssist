package com.tourguide.service.trial;

import java.util.List;

import com.tourguide.model.IntervalType;

public interface IntervalTypeService {

	List<IntervalType> getList();
	
	IntervalType getIntervalTypeById(Long id);
}
