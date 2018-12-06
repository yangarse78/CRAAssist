package com.tourguide.service.trial.visit;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.visit.VisitTypeDao;
import com.tourguide.model.VisitType;

@Service
public class VisitTypeServiceImpl implements VisitTypeService {

	@Autowired
	private VisitTypeDao visitTypeDao; 
	
	@Transactional
	public List<VisitType> getList() {
		return visitTypeDao.getList();
	}

	@Transactional
	public VisitType getVisitTypeById(Long id) {
		return visitTypeDao.getByKey(id);
	}

	
	
}
