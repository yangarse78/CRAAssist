package com.tourguide.service.trial.visit;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tourguide.dao.trial.visit.TrialVisitDefDao;
import com.tourguide.model.SiteVisitType;
import com.tourguide.model.TrialTimeUnit;
import com.tourguide.model.TrialVisitDef;
import com.tourguide.model.VisitTreatment;
import com.tourguide.model.VisitType;

@Service
public class TrialVisitDefServiceImpl implements TrialVisitDefService {

	@Autowired
	private TrialVisitDefDao trialVisitDefDao;
	
	
	
	@Autowired
	private VisitTreatmentService visitTreatmentService;
	
	@Autowired
	private TrialTimeUnitService trialTimeUnitService;
	
	@Autowired
	private VisitTypeService visitTypeService;
	
	@Autowired
	private SiteVisitTypeService siteVisitTypeService;
	

	
	
	
	@Override
	public List<VisitTreatment> getTreatmentList() {
		return visitTreatmentService.getList();
	}

	@Override
	public List<VisitType> getVisitTypeList() {
		return visitTypeService.getList();
	}

	@Override
	public List<TrialTimeUnit> getTrialTimeUnitList() {
		return trialTimeUnitService.getList();
	}

	@Override
	public List<SiteVisitType> getSiteVisitTypeList() {
		return siteVisitTypeService.getList();
	}


	@Override
	public List<TrialVisitDef> getPerTrial(Long id) {
		return trialVisitDefDao.getPerTrial(id);
	}

	@Transactional
	public List<TrialVisitDef> getList() {
		return trialVisitDefDao.getList();
	}

	
	@Transactional
	public void save(TrialVisitDef visit) {
		trialVisitDefDao.persist(visit);
	}
	
	@Override
	public TrialTimeUnit getTrialTimeUnitById(Long selectedTrialTimeUnit) {
		return trialTimeUnitService.getTrialTimeUnitById(selectedTrialTimeUnit);
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
	public VisitTreatment getTreatmentById(Long selectedTreatment) {
		return visitTreatmentService.getTreatmentById(selectedTreatment);
	}










	
	
}
