package com.yer.universitymanagement.model;

public class ProfessorDto {
	private int id;
	
	private String name;
	
	private int departmentId;

	public ProfessorDto() {
		super();
	}

	public ProfessorDto(int id, String name, int departmentId) {
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
