package com.tourguide.service.trial.visit;

import java.util.List;

import com.tourguide.model.IntervalType;
import com.tourguide.model.SiteVisitType;
import com.tourguide.model.TrialVisitDef;
import com.tourguide.model.VisitTreatment;
import com.tourguide.model.VisitType;

public interface TrialVisitDefService {

	List<TrialVisitDef> getList();

	IntervalType getIntervalTypeById(Long selectedIntervalType);

	VisitType getVisitTypeById(Long selectedVisitType);

	SiteVisitType getSiteVisitTypeById(Long selectedSiteVisitType);

	List<VisitTreatment> getTreatmentList();

	List<VisitType> getVisitTypeList();

	List<IntervalType> getIntervalTypeList();

	List<SiteVisitType> getSiteVisitTypeList();
}
