package com.yer.universitymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yer.universitymanagement.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
