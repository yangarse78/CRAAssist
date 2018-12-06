package com.tourguide.dao.trial.visit;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.TrialTimeUnit;

@Repository
public class TrialTimeUnitDaoImpl extends AbstractDao<Long, TrialTimeUnit> implements TrialTimeUnitDao {

	@Override
	public List<TrialTimeUnit> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<TrialTimeUnit> query = getSession().createQuery("from TrialTimeUnit");
		return query.getResultList();
	}

	
	
}
