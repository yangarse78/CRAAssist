package com.tourguide.dao.trial.visit;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.VisitType;

@Repository
public class VisitTypeDaoImpl extends AbstractDao<Long, VisitType> implements VisitTypeDao{
	
	@Override
	public List<VisitType> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<VisitType> query = getSession().createQuery("from VisitType");
		return query.getResultList();
	}


	@Override
	public VisitType getVisitTypeById(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<VisitType> query = getSession().
																createQuery("from VisitType v where v.id = :id")
																.setParameter("id", id);
		try {
			return query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
}
