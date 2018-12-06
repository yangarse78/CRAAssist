package com.tourguide.dao.trial.visit;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.TrialVisitDef;

@Repository
public class TrialVisitDefDaoImpl extends AbstractDao<Long, TrialVisitDef> implements TrialVisitDefDao {

	
	@Override
	public List<TrialVisitDef> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<TrialVisitDef> query = getSession().createQuery("from TrialVisitDef");
		return query.getResultList();
	}

	@Override
	public List<TrialVisitDef> getPerTrial(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<TrialVisitDef> query = getSession().createQuery("from TrialVisitDef t where t.trial.id=:trial_id ").setParameter("trial_id",	 id);
		return query.getResultList();
	}
}
