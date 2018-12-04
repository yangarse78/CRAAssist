package com.tourguide.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISIT_TREATMENT")
public class VisitTreatment {
	
	@Id
	private Long id;
	
	@Column(name = "TREATMENT")
	private String treatment;

	public VisitTreatment() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
}
