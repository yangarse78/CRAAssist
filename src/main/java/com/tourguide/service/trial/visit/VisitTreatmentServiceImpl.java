package com.tourguide.service.trial.visit;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.visit.VisitTreatmentDao;
import com.tourguide.model.VisitTreatment;

@Service
public class VisitTreatmentServiceImpl implements VisitTreatmentService {

	@Autowired
	private VisitTreatmentDao visitTreatmentDao; 
	
	@Transactional
	public List<VisitTreatment> getList() {
		return visitTreatmentDao.getList();
	}
}
