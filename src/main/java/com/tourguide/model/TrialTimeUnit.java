package com.tourguide.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TRIAL_TIME_UNIT")
public class TrialTimeUnit {

	@Id
	private Long id;
	
	@Column(name = "NAME")
	private String name;

	
	
	public TrialTimeUnit() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
