package com.tourguide.dao.patient;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.Patient;

@Repository
public class PatientDaoImpl extends AbstractDao<Long, Patient> implements PatientDao {

	private static final Logger logger = LoggerFactory.getLogger(PatientDaoImpl.class);
	
	@Override
	public List<Patient> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<Patient> query = getSession().createQuery("from Patient");
		return query.getResultList();
	}

	@Override
	public List<Patient> getPerTrial(Long id) {
		@SuppressWarnings("unchecked")
		TypedQuery<Patient> query = getSession().createQuery("from Patient p where p.trial.id=:trial_id ").setParameter("trial_id",	 id);
		return query.getResultList();
	}



}
