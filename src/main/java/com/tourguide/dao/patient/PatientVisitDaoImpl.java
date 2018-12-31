package com.tourguide.dao.patient;

import java.util.List;

import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.tourguide.dao.AbstractDao;
import com.tourguide.model.PatientVisit;


@Repository
public class PatientVisitDaoImpl extends AbstractDao<Long, PatientVisit> implements PatientVisitDao {

	private static final Logger logger = LoggerFactory.getLogger(PatientVisitDaoImpl.class);
	

	@Override
	public List<PatientVisit> getNearestNotVisitedPatients() {
		String hql = 	"from PatientVisit pv where NOW() BETWEEN " + 
								"pv.windowBefore AND pv.windowAfter " + 
								"and pv.plannedVisitDate is null and (pv.isVisited is null or pv.isVisited = 0)"; 
		@SuppressWarnings("unchecked")
		TypedQuery<PatientVisit> query = getSession().createQuery(hql);
		List<PatientVisit> list = query.getResultList();
		return list;
	}


	@Override
	public List<PatientVisit> getScheduledVisits() {
		String hql = 	"from PatientVisit pv where NOW() BETWEEN " + 
								"pv.windowBefore AND pv.windowAfter " + 
								"and pv.plannedVisitDate is not null"; 
		@SuppressWarnings("unchecked")
		TypedQuery<PatientVisit> query = getSession().createQuery(hql);
		List<PatientVisit> list = query.getResultList();
		return list;
	}
}
