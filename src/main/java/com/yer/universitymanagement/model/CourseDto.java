package com.yer.universitymanagement.model;

public class CourseDto {
	private int id;
	
	private String name;
	
	private int departmentId;
	
	private int credits;

	public CourseDto() {
		super();
	}

	public CourseDto(int id, String name, int departmentId, int credits) {
		super();
		this.id = id;
		this.name = name;
		this.departmentId = departmentId;
		this.credits = credits;
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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
}
