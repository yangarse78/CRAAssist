package com.tourguide.dao.patient;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.Patient;

@Repository
public class PatientDaoImpl extends AbstractDao<Long, PatientDaoImpl> implements PatientDao {

	
	@Override
	public List<Patient> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<Patient> query = getSession().createQuery("from Patient");
		return query.getResultList();
	}

}
