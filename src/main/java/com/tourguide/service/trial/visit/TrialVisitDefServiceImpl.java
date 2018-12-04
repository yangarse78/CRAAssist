package com.tourguide.service.trial.visit;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.visit.TrialVisitDefDao;
import com.tourguide.model.IntervalType;
import com.tourguide.model.SiteVisitType;
import com.tourguide.model.TrialVisitDef;
import com.tourguide.model.VisitTreatment;
import com.tourguide.model.VisitType;

@Service
public class TrialVisitDefServiceImpl implements TrialVisitDefService {

	@Autowired
	private TrialVisitDefDao trialVisitDefDao;
	
	
	
	@Autowired
	private VisitTreatmentService visitTreatmentTypeService;
	
	@Autowired
	private IntervalTypeService intervalTypeService;
	
	@Autowired
	private VisitTypeService visitTypeService;
	
	@Autowired
	private SiteVisitTypeService siteVisitTypeService;
	
	
	
	
	
	
	
	@Transactional
	public List<TrialVisitDef> getList() {
		return trialVisitDefDao.getList();
	}

	
	
	
	
	@Override
	public IntervalType getIntervalTypeById(Long selectedIntervalType) {
		return intervalTypeService.getIntervalTypeById(selectedIntervalType);
	}

	@Override
	public VisitType getVisitTypeById(Long selectedVisitType) {
		return visitTypeService.getVisitTypeById(selectedVisitType);
	}

	@Override
	public SiteVisitType getSiteVisitTypeById(Long selectedSiteVisitType) {
		return siteVisitTypeService.getSiteVisitTypeById(selectedSiteVisitType);
	}

	@Override
	public List<VisitTreatment> getTreatmentList() {
		return visitTreatmentTypeService.getList();
	}

	@Override
	public List<VisitType> getVisitTypeList() {
		return visitTypeService.getList();
	}

	@Override
	public List<IntervalType> getIntervalTypeList() {
		return intervalTypeService.getList();
	}

	@Override
	public List<SiteVisitType> getSiteVisitTypeList() {
		return siteVisitTypeService.getList();
	}

	
	
}
