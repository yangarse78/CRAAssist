package com.tourguide.dao.trial;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.SiteVisitType;

@Repository
public class SiteVisitTypeDaoImpl extends AbstractDao<Long, SiteVisitTypeDaoImpl>implements SiteVisitTypeDao {
	
	@Override
	public List<SiteVisitType> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<SiteVisitType> query = getSession().createQuery("from SiteVisitType");
		return query.getResultList();
	}


	@Override
	public SiteVisitType getSiteVisitTypeById(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<SiteVisitType> query = getSession()
																		.createQuery("from SiteVisitType s where s.id = :id")
																		.setParameter("id", id);
		try {
			return query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

}
