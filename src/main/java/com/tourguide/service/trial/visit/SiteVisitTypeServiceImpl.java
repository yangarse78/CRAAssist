package com.tourguide.service.trial.visit;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.visit.SiteVisitTypeDao;
import com.tourguide.model.SiteVisitType;

@Service
public class SiteVisitTypeServiceImpl implements SiteVisitTypeService {

	@Autowired
	private SiteVisitTypeDao siteVisitTypeDao;
	
	
	@Transactional
	public List<SiteVisitType> getList() {
		return siteVisitTypeDao.getList();
	}


	@Transactional
	public SiteVisitType getSiteVisitTypeById(Long id) {
		return siteVisitTypeDao.getByKey(id);
	}

}
