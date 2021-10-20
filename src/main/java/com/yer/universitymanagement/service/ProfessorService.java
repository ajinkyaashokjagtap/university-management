package com.yer.universitymanagement.service;

import org.springframework.stereotype.Service;

import com.yer.universitymanagement.model.ProfessorDto;

@Service
public interface ProfessorService {
	ProfessorDto saveProfessorDetails(ProfessorDto professor);
	
	ProfessorDto getProfessorDetailsByProfessorId(int professorId);
	
	void deleteProfessor(int professorId);
}
