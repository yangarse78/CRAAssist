package com.tourguide.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PATIENT_VISIT")
public class PatientVisit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;
	
	@OneToOne
	private TrialVisitDef defVisit;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "WINDOW_BEFORE")
	private Date windowBefore;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "VISIT_DATE")
	private Date visitDate;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "WINDOW_AFTER")
	private Date windowAfter;
	
	@DateTimeFormat(pattern="dd/MM/yyyy")
	@Column(name = "PLANNED_VISIT")
	private Date plannedVisitDate;
	
	@Column(name = "IS_VISITED")
	private Boolean isVisited;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "patient_id")
	private Patient patient;
	
	
	public PatientVisit() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TrialVisitDef getDefVisit() {
		return defVisit;
	}

	public void setDefVisit(TrialVisitDef defVisit) {
		this.defVisit = defVisit;
	}

	public Date getWindowBefore() {
		return windowBefore;
	}

	public void setWindowBefore(Date windowBefore) {
		this.windowBefore = windowBefore;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public Date getWindowAfter() {
		return windowAfter;
	}

	public void setWindowAfter(Date windowAfter) {
		this.windowAfter = windowAfter;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Date getPlannedVisitDate() {
		return plannedVisitDate;
	}

	public void setPlannedVisitDate(String plannedVisitDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date parsed = null;
		try {
			parsed = format.parse(plannedVisitDate);
		} catch (ParseException e) {

		}
		this.plannedVisitDate = parsed;
	}

	public Boolean getIsVisited() {
		return isVisited;
	}

	public void setIsVisited(Boolean isVisited) {
		this.isVisited = isVisited;
	}
}
