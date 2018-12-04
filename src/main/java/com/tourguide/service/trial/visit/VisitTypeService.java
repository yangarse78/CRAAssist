package com.tourguide.service.trial.visit;

import java.util.List;

import com.tourguide.model.VisitType;

public interface VisitTypeService {

	List<VisitType> getList();

	VisitType getVisitTypeById(Long id);
}
