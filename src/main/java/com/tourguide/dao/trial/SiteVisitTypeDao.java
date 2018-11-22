package com.tourguide.dao.trial;

import java.util.List;

import com.tourguide.model.SiteVisitType;

public interface SiteVisitTypeDao {

	List<SiteVisitType> getList();

	SiteVisitType getSiteVisitTypeById(Long id);
}
