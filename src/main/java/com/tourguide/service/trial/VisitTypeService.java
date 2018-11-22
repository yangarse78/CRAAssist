package com.tourguide.service.trial;

import java.util.List;

import com.tourguide.model.VisitType;

public interface VisitTypeService {

	List<VisitType> getList();

	VisitType getVisitTypeById(Long id);
}
