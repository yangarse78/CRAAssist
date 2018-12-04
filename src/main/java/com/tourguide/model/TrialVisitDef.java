package com.tourguide.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TRIAL_VISIT_DEF")
public class TrialVisitDef {
	
	@Transient
	private Long selectedTreatment;
	@Transient
	private Long selectedVisitType;
	@Transient
	private Long selectedIntervalType;
	@Transient
	private Long selectedSiteVisitType;
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@OneToOne
	private VisitTreatment treatment;
	
	@OneToOne
	private VisitType visitType;
	
	@Column(name = "TIME_INTERVAL")
	private int interval;
	
	@OneToOne
	private IntervalType intervalType;

	@OneToOne
	private SiteVisitType siteVisitType;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "trial_id")
	private Trial trial;
	
	
	public TrialVisitDef() {
	}

	public Long getSelectedTreatment() {
		return selectedTreatment;
	}

	public void setSelectedTreatment(Long selectedTreatment) {
		this.selectedTreatment = selectedTreatment;
	}

	public Long getSelectedVisitType() {
		return selectedVisitType;
	}

	public void setSelectedVisitType(Long selectedVisitType) {
		this.selectedVisitType = selectedVisitType;
	}

	public Long getSelectedIntervalType() {
		return selectedIntervalType;
	}

	public void setSelectedIntervalType(Long selectedIntervalType) {
		this.selectedIntervalType = selectedIntervalType;
	}

	public Long getSelectedSiteVisitType() {
		return selectedSiteVisitType;
	}

	public void setSelectedSiteVisitType(Long selectedSiteVisitType) {
		this.selectedSiteVisitType = selectedSiteVisitType;
	}

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public VisitTreatment getTreatment() {
		return treatment;
	}

	public void setTreatment(VisitTreatment treatment) {
		this.treatment = treatment;
	}

	public VisitType getVisitType() {
		return visitType;
	}

	public void setVisitType(VisitType visitType) {
		this.visitType = visitType;
	}

	public int getInterval() {
		return interval;
	}

	public void setInterval(int interval) {
		this.interval = interval;
	}

	public IntervalType getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(IntervalType intervalType) {
		this.intervalType = intervalType;
	}

	public SiteVisitType getSiteVisitType() {
		return siteVisitType;
	}

	public void setSiteVisitType(SiteVisitType siteVisitType) {
		this.siteVisitType = siteVisitType;
	}

	public Trial getTrial() {
		return trial;
	}

	public void setTrial(Trial trial) {
		this.trial = trial;
	}
	
}
