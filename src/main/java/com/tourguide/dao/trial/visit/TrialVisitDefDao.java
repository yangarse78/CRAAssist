package com.tourguide.dao.trial.visit;

import java.util.List;

import com.tourguide.model.TrialVisitDef;

public interface TrialVisitDefDao {

	List<TrialVisitDef> getList();

	void persist(TrialVisitDef visit);

	List<TrialVisitDef> getPerTrial(Long id);
}
