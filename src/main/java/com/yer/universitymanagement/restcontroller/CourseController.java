package com.yer.universitymanagement.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yer.universitymanagement.model.CourseDto;
import com.yer.universitymanagement.service.CourseService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/course")
public class CourseController {
	@Autowired
	CourseService courseService;

	@PostMapping("")
	public ResponseEntity<CourseDto> createCourse(@RequestBody CourseDto course) {
		try {
			course = courseService.saveCourseDetails(course);
			if (course != null) {
				return ResponseEntity.ok(course);
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}

	@DeleteMapping("/{courseId}")
	public ResponseEntity<Boolean> deleteCourse(@PathVariable int courseId) {
		try {
			courseService.deleteCourse(courseId);
			return ResponseEntity.ok(true);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
}
