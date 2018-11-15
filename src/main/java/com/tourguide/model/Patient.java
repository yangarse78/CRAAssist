package com.tourguide.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PATIENTS")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ID", updatable = false, nullable = false)
	private Long id;

	@Column(name = "FIRST_NAME")
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	@NotEmpty(message = "Please Enter your first name")
	private String firstName;

	@Column(name = "LAST_NAME")
	@Size(max = 20, min = 3, message = "{user.name.invalid}")
	@NotEmpty(message = "Please Enter your last name")
	private String lastName;

	
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
   
}
