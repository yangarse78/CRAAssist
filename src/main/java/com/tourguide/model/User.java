package com.tourguide.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USERS")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "userId", nullable = false, updatable = false)
	private Long id;
		
	@Column(name = "FIRST_NAME")
   	@Size(max = 20, min = 3, message = "{user.name.invalid}")
   	@NotEmpty(message="Please Enter your first name")
   	private String firstName;
   
   	@Column(name = "LAST_NAME")
   	@Size(max = 20, min = 3, message = "{user.name.invalid}")
   	@NotEmpty(message="Please Enter your last name")
   	private String lastName;
   	
   	@Column(name = "EMAIL", unique = true)
   	@Email(message = "{user.email.invalid}")
   	@NotEmpty(message="Please Enter your email")
   	private String email;
	
   	@Column(name = "AGE")
   	@NotNull(message="Please Enter your age")
   	private Integer age;

   
	public User() {}

	
	
	
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
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
