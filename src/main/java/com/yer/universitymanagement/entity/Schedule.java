package com.yer.universitymanagement.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Schedule")
public class Schedule {
	@Id
	private int id;
	
	private int professorId;
	
	private int courseId;
	
	private int semester;
	
	private int year;

	public Schedule() {
		super();
	}

	public Schedule(int id, int professorId, int courseId, int semester, int year) {
		super();
		this.id = id;
		this.professorId = professorId;
		this.courseId = courseId;
		this.semester = semester;
		this.year = year;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProfessorId() {
		return professorId;
	}

	public void setProfessorId(int professorId) {
		this.professorId = professorId;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public int getSemester() {
		return semester;
	}

	public void setSemester(int semester) {
		this.semester = semester;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
