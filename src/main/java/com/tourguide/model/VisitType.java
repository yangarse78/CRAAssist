package com.tourguide.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VISIT_TYPE")
public class VisitType {

	@Id
//	@Column(name = "visitTypeId", nullable = false, updatable = false)
	private int id;
	
	@Column(name = "VISIT_TYPE")
	private String visitType;

	public VisitType() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVisitType() {
		return visitType;
	}

	public void setVisitType(String visitType) {
		this.visitType = visitType;
	}
}
