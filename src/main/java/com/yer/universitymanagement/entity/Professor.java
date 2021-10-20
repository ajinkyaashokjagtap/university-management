package com.yer.universitymanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Professor")
public class Professor {
	@Id
	private int id;
	
	private String name;
	
	private int departmentId;

	public Professor() {
		super();
	}

	public Professor(int id, String name, int departmentId) {
		super();
		this.id = id;
		this.name = name;
		this.departmentId = departmentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
}
