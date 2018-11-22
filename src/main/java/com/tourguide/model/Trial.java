package com.tourguide.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TRIAL")
public class Trial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@Column(name = "TRIAL_NUM")
	@NotEmpty
	private String trialNum;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "NUM_OF_VISITS")
	@NotNull(message = "Number of visits cannot be empty")
	private int numOfVisits;
	
	@Column(name = "COMMENT")
	private String comment;
	
	@OneToOne
	private VisitType visitType;
	
	@Column(name = "TIME_INTERVAL")
	private int interval;
	
	@OneToOne
	private IntervalType intervalType;

	@OneToOne
	private SiteVisitType siteVisitType;
	
	@OneToMany(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> patients;
	
	
	
	
	@Transient
	private Long selectedVisitType;
	@Transient
	private Long selectedIntervalType;
	@Transient
	private Long selectedSiteVisitType;
	
		
	public Trial() {}
	
	
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
	
	public String getTrialNum() {
		return trialNum;
	}

	public void setTrialNum(String trialNum) {
		this.trialNum = trialNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumOfVisits() {
		return numOfVisits;
	}

	public void setNumOfVisits(int numOfVisits) {
		this.numOfVisits = numOfVisits;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	
}
