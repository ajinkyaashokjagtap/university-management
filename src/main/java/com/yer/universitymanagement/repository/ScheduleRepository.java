package com.yer.universitymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yer.universitymanagement.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {
	public Schedule findById(int scheduleId);
	
	public Schedule findByProfessorId(int professorId);
	
	public Schedule findByCourseId(int courseId);
}
