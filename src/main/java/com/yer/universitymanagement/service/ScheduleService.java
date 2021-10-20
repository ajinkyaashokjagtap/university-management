package com.yer.universitymanagement.service;

import org.springframework.stereotype.Service;

import com.yer.universitymanagement.model.ScheduleDto;

@Service
public interface ScheduleService {
	ScheduleDto saveScheduleDetails(ScheduleDto schedule);
	
	ScheduleDto getScheduleDetailsByScheduleId(int scheduleId);
	
	void deleteSchedule(int scheduleId);
}
