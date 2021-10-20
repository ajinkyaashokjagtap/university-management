package com.yer.universitymanagement.service;

import org.springframework.stereotype.Service;

import com.yer.universitymanagement.model.CourseDto;

@Service
public interface CourseService {
	CourseDto saveCourseDetails(CourseDto course);
	
	CourseDto getCourseDetailsByCourseName(String courseName);
	
	CourseDto getCourseDetailsByCourseId(int courseId);
	
	void deleteCourse(int courseId);
}
