package com.yer.universitymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yer.universitymanagement.entity.Schedule;
import com.yer.universitymanagement.model.ScheduleDto;
import com.yer.universitymanagement.repository.ScheduleRepository;
import com.yer.universitymanagement.service.ScheduleService;

@Service
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepository;

	@Override
	public ScheduleDto saveScheduleDetails(ScheduleDto schedule) {
		try {
			if (schedule != null) {
				Schedule scheduleObj = new Schedule(schedule.getId(), schedule.getProfessorId(), schedule.getCourseId(),
						schedule.getSemester(), schedule.getYear());
				scheduleRepository.save(scheduleObj);
				schedule.setId(scheduleObj.getId());
			}
		} catch (Exception ex) {
			throw ex;
		}

		return schedule;
	}
	
	@Override
	public ScheduleDto getScheduleDetailsByScheduleId(int scheduleId) {
		try {
			Schedule scheduleObj = scheduleRepository.findById(scheduleId);
			if (scheduleObj != null) {
				ScheduleDto schedule = new ScheduleDto(scheduleObj.getId(), scheduleObj.getProfessorId(), scheduleObj.getCourseId(),
						scheduleObj.getSemester(), scheduleObj.getYear());

				return schedule;
			}
		} catch (Exception ex) {
			throw ex;
		}

		return null;
	}
	
	@Override
	public void deleteSchedule(int scheduleId) {
		try {
			scheduleRepository.deleteById(scheduleId);
		} catch (Exception ex) {
			throw ex;
		}
	}
}
