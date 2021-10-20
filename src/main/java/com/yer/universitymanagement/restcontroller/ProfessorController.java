package com.yer.universitymanagement.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yer.universitymanagement.model.ProfessorDto;
import com.yer.universitymanagement.service.ProfessorService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/professor")
public class ProfessorController {
	@Autowired
	ProfessorService professorService;

	@PostMapping("")
	public ResponseEntity<ProfessorDto> CreateProfessor(@RequestBody ProfessorDto professor) {
		try {
			professor = professorService.saveProfessorDetails(professor);
			if (professor != null) {
				return ResponseEntity.ok(professor);
			} else {
				return ResponseEntity.internalServerError().build();
			}
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@DeleteMapping("/{professorId}")
	public ResponseEntity<Boolean> deleteProfessor(@PathVariable int professorId) {
		try {
			professorService.deleteProfessor(professorId);
			return ResponseEntity.ok(true);
		} catch (Exception ex) {
			return ResponseEntity.badRequest().build();
		}
	}
}
