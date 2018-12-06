package com.tourguide.service.trial.visit;

import java.util.List;

import com.tourguide.model.SiteVisitType;
import com.tourguide.model.TrialTimeUnit;
import com.tourguide.model.TrialVisitDef;
import com.tourguide.model.VisitTreatment;
import com.tourguide.model.VisitType;

public interface TrialVisitDefService {

	List<TrialVisitDef> getList();

	TrialTimeUnit getTrialTimeUnitById(Long selectedTrialTimeUnit);

	List<TrialTimeUnit> getTrialTimeUnitList();

	VisitType getVisitTypeById(Long selectedVisitType);

	SiteVisitType getSiteVisitTypeById(Long selectedSiteVisitType);

	VisitTreatment getTreatmentById(Long selectedTreatment);

	List<VisitTreatment> getTreatmentList();

	List<VisitType> getVisitTypeList();

	List<SiteVisitType> getSiteVisitTypeList();

	void save(TrialVisitDef visit);

	List<TrialVisitDef> getPerTrial(Long id);

}
