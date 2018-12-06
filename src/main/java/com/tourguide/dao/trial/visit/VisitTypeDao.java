package com.tourguide.dao.trial.visit;

import java.util.List;

import com.tourguide.model.VisitType;

public interface VisitTypeDao {

	List<VisitType> getList();

	VisitType getByKey(Long id);
}
