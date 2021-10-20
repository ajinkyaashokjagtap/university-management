package com.yer.universitymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yer.universitymanagement.entity.Department;
import com.yer.universitymanagement.model.DepartmentDto;
import com.yer.universitymanagement.repository.DepartmentRepository;
import com.yer.universitymanagement.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public DepartmentDto saveDepartmentDetails(DepartmentDto department) {
		try {
			if (department != null) {
				Department departmentObj = new Department(department.getId(), department.getName());
				departmentRepository.save(departmentObj);
				department.setId(departmentObj.getId());
			}
		} catch (Exception ex) {
			throw ex;
		}
		
		return department;
	}
	
	@Override
	public DepartmentDto getDepartmentDetailsByDepartmentId(int departmentId) {
		try {
			Department departmentObj = departmentRepository.findById(departmentId);
			if (departmentObj != null) {
				DepartmentDto department = new DepartmentDto(departmentObj.getId(), departmentObj.getName());

				return department;
			}
		} catch (Exception ex) {
			throw ex;
		}

		return null;
	}
	
	@Override
	public void deleteDepartment(int departmentId) {
		try {
			departmentRepository.deleteById(departmentId);
		} catch (Exception ex) {
			throw ex;
		}
	}

}
