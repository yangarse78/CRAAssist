package com.tourguide.dao.trial;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.IntervalType;

@Repository
public class IntervalTypeDaoImpl extends AbstractDao<Long, IntervalTypeDaoImpl> implements IntervalTypeDao {

	@Override
	public List<IntervalType> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<IntervalType> query = getSession().createQuery("from IntervalType");
		return query.getResultList();
	}

	@Override
	public IntervalType getIntervalTypeById(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<IntervalType> query = getSession()
																	.createQuery("from IntervalType i where i.id = :id")
																	.setParameter("id", id);
		try {
			return query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}
	
	
}
