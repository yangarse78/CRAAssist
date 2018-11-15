package com.tourguide.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "INTERVAL_TYPE")
public class IntervalType {

	@Id
//	@Column(name = "intervalTypeId", nullable = false, updatable = false)
	private int id;
	
	@Column(name = "INTERVAL_TYPE")
	private String intervalType;

	
	public IntervalType() {}


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIntervalType() {
		return intervalType;
	}

	public void setIntervalType(String intervalType) {
		this.intervalType = intervalType;
	}
}
