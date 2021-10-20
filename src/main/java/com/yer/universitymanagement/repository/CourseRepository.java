package com.yer.universitymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yer.universitymanagement.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public Course findByName(String courseName);
	
	public Course findById(int courseId);
}
