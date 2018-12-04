package com.tourguide.dao.trial.visit;

import java.util.List;

import com.tourguide.model.TrialVisitDef;

public interface TrialVisitDefDao {

	List<TrialVisitDef> getList();

	void save(TrialVisitDef visit);
}
