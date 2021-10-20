package com.yer.universitymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yer.universitymanagement.entity.Course;
import com.yer.universitymanagement.model.CourseDto;
import com.yer.universitymanagement.repository.CourseRepository;
import com.yer.universitymanagement.service.CourseService;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseRepository courseRepository;

	@Override
	public CourseDto saveCourseDetails(CourseDto course) {
		try {
			if (course != null) {
				Course courseObj = new Course(course.getId(), course.getName(), course.getDepartmentId(),
						course.getCredits());
				courseRepository.save(courseObj);
				course.setId(courseObj.getId());
			}
		} catch (Exception ex) {
			throw ex;
		}

		return course;
	}

	@Override
	public CourseDto getCourseDetailsByCourseName(String courseName) {
		try {
			if (courseName != null && !courseName.isBlank()) {
				Course courseObj = courseRepository.findByName(courseName);
				if (courseObj != null) {
					CourseDto course = new CourseDto(courseObj.getId(), courseObj.getName(),
							courseObj.getDepartmentId(), courseObj.getCredits());

					return course;
				}
			}
		} catch (Exception ex) {
			throw ex;
		}

		return null;
	}

	@Override
	public CourseDto getCourseDetailsByCourseId(int courseId) {
		try {
			Course courseObj = courseRepository.findById(courseId);
			if (courseObj != null) {
				CourseDto course = new CourseDto(courseObj.getId(), courseObj.getName(), courseObj.getDepartmentId(),
						courseObj.getCredits());

				return course;
			}
		} catch (Exception ex) {
			throw ex;
		}

		return null;
	}

	@Override
	public void deleteCourse(int courseId) {
		try {
			courseRepository.deleteById(courseId);
		} catch (Exception ex) {
			throw ex;
		}
	}
}
