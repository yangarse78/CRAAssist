package com.tourguide.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "TRIAL")
public class Trial {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID")
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

	@OneToMany(mappedBy = "trial", cascade = CascadeType.ALL)
    private List<TrialVisitDef> visits;
	
	@OneToMany(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Patient> patients;
	

	public Trial() {}
	

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

	public List<TrialVisitDef> getVisits() {
		return visits;
	}

	public void setVisits(List<TrialVisitDef> visits) {
		this.visits = visits;
	}

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

	
}
