package com.tourguide.dao.trial.visit;

import java.util.List;

import com.tourguide.model.SiteVisitType;

public interface SiteVisitTypeDao {

	List<SiteVisitType> getList();

	SiteVisitType getByKey(Long id);
}
