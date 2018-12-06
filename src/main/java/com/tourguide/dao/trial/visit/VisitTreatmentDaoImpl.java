package com.tourguide.dao.trial.visit;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.VisitTreatment;

@Repository
public class VisitTreatmentDaoImpl extends AbstractDao<Long, VisitTreatment> implements VisitTreatmentDao {

	@Override
	public List<VisitTreatment> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<VisitTreatment> query = getSession().createQuery("from VisitTreatment");
		return query.getResultList();
	}


}
