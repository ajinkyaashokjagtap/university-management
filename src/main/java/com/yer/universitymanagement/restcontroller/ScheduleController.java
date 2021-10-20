package com.yer.universitymanagement.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yer.universitymanagement.model.ScheduleDto;
import com.yer.universitymanagement.service.ScheduleService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
	@Autowired
	ScheduleService scheduleService;

	@PostMapping("")
	public ResponseEntity<ScheduleDto> CreateSchedule(@RequestBody ScheduleDto schedule) {
		try {
			schedule = scheduleService.saveScheduleDetails(schedule);
			if (schedule != null) {
				return ResponseEntity.ok(schedule);
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{scheduleId}")
	public ResponseEntity<Boolean> deleteSchedule(@PathVariable int scheduleId) {
		try {
			scheduleService.deleteSchedule(scheduleId);
			return ResponseEntity.ok(true);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
}
