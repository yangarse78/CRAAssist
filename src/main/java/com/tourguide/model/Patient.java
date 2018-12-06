package com.tourguide.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "PATIENTS")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	private Long id;

	@Column(name = "SUBJECT_ID")
	@Size(max = 20, min = 3, message = "{patient.subject.id.invalid}")
	@NotEmpty(message = "Please Enter your Subject number")
	private String subjectId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "trial_id")
	private Trial trial;
		
	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "TEL_NUM")
	@NotEmpty(message = "Please enter telephone number")
	private String telepone;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SCREENING_DATE")
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Date screeningDate;
	
	@Column(name = "COMMENT")
	private String comment;

	
	
	@Transient
	private Long selectedTrial;
	
	public Patient() {}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public Trial getTrial() {
		return trial;
	}

	public void setTrial(Trial trial) {
		this.trial = trial;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getTelepone() {
		return telepone;
	}

	public void setTelepone(String telepone) {
		this.telepone = telepone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getScreeningDate() {
		return screeningDate;
	}

	public void setScreeningDate(Date screeningDate) {
		this.screeningDate = screeningDate;
	}

	public Long getSelectedTrial() {
		return selectedTrial;
	}

	public void setSelectedTrial(Long selectedTrial) {
		this.selectedTrial = selectedTrial;
	}

}
