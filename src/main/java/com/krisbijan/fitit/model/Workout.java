package com.krisbijan.fitit.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Table
@Entity
public class Workout {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Integer id;

	@Size(min = 1, message = "Name should have at least 1 characters")
	@Column
	private String name;
	
	@Column
	private Boolean template;
	
	@Column
	private String userEmail;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "workout")
	private Set<Exercise> exercises = new HashSet<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getTemplate() {
		return template;
	}

	public void setTemplate(Boolean template) {
		this.template = template;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Set<Exercise> getExercises() {
		return exercises;
	}

	public void setExercises(Set<Exercise> exercises) {
		this.exercises = exercises;
	}
	
}
