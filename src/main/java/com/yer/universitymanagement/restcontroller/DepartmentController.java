package com.yer.universitymanagement.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yer.universitymanagement.model.DepartmentDto;
import com.yer.universitymanagement.service.DepartmentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
	@Autowired
	DepartmentService departmentService;

	@PostMapping("")
	public ResponseEntity<DepartmentDto> CreateDepartment(@RequestBody DepartmentDto department) {
		try {
			department = departmentService.saveDepartmentDetails(department);
			if (department != null) {
				return ResponseEntity.ok(department);
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{departmentId}")
	public ResponseEntity<Boolean> deleteDepartment(@PathVariable int departmentId) {
		try {
			departmentService.deleteDepartment(departmentId);
			return ResponseEntity.ok(true);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
}
