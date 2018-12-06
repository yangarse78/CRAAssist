package com.tourguide.dao.trial.visit;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.SiteVisitType;

@Repository
public class SiteVisitTypeDaoImpl extends AbstractDao<Long, SiteVisitType> implements SiteVisitTypeDao {
	
	@Override
	public List<SiteVisitType> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<SiteVisitType> query = getSession().createQuery("from SiteVisitType");
		return query.getResultList();
	}


}
