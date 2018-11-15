package com.tourguide.dao.patient;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tourguide.model.Patient;

@Repository
public class PatientDaoImpl implements PatientDao {

	@Autowired
	 private SessionFactory sessionFactory;
	
	
	
	@Override
	public List<Patient> getList() {
		@SuppressWarnings("unchecked")
		TypedQuery<Patient> query = sessionFactory.getCurrentSession().createQuery("from Patient");
		return query.getResultList();
	}

}
