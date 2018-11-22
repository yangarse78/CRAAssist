package com.tourguide.service.trial;

import java.util.List;

import com.tourguide.model.SiteVisitType;

public interface SiteVisitTypeService {

	List<SiteVisitType> getList();

	SiteVisitType getSiteVisitTypeById(Long id);
}
