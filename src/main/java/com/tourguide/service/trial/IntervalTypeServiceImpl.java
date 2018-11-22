package com.tourguide.service.trial;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.IntervalTypeDao;
import com.tourguide.model.IntervalType;

@Service
public class IntervalTypeServiceImpl implements IntervalTypeService {

	@Autowired
	private IntervalTypeDao intervalTypeDao;
	
	@Transactional	
	public List<IntervalType> getList() {
		return intervalTypeDao.getList();
	}

	@Transactional
	public IntervalType getIntervalTypeById(Long id) {
		return intervalTypeDao.getIntervalTypeById(id);
	}

	
	
}
