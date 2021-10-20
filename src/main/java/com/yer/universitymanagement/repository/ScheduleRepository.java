package com.yer.universitymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yer.universitymanagement.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

}
