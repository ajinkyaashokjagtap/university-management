package com.yer.universitymanagement.service;

import org.springframework.stereotype.Service;

import com.yer.universitymanagement.model.DepartmentDto;

@Service
public interface DepartmentService {
	DepartmentDto saveDepartmentDetails(DepartmentDto department);
	
	DepartmentDto getDepartmentDetailsByDepartmentId(int departmentId);
	
	void deleteDepartment(int departmentId);
}
