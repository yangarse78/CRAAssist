package com.tourguide.dao.trial;

import java.util.List;

import com.tourguide.model.IntervalType;

public interface IntervalTypeDao {

	List<IntervalType> getList();
	
	IntervalType getIntervalTypeById(Long id);
}
