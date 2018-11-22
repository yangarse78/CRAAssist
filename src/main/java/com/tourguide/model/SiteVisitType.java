package com.tourguide.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SITE_VISIT_TYPE")
public class SiteVisitType {

	@Id
	private Long id;
	
	@Column(name = "SITE_VISIT_TYPE")
	private String siteVisitType;

	
	public SiteVisitType() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSiteVisitType() {
		return siteVisitType;
	}

	public void setSiteVisitType(String siteVisitType) {
		this.siteVisitType = siteVisitType;
	}
}
