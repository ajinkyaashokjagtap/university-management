package com.yer.universitymanagement.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yer.universitymanagement.entity.Professor;
import com.yer.universitymanagement.model.ProfessorDto;
import com.yer.universitymanagement.repository.ProfessorRepository;
import com.yer.universitymanagement.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService {

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Override
	public ProfessorDto saveProfessorDetails(ProfessorDto professor) {
		try {
			if (professor != null) {
				Professor professorObj = new Professor(professor.getId(), professor.getName(), professor.getDepartmentId());
				professorRepository.save(professorObj);
				professor.setId(professorObj.getId());
			}
		} catch (Exception ex) {
			throw ex;
		}
		
		return professor;
	}
	
	@Override
	public ProfessorDto getProfessorDetailsByProfessorId(int professorId) {
		try {
			Professor professorObj = professorRepository.findById(professorId);
			if (professorObj != null) {
				ProfessorDto professor = new ProfessorDto(professorObj.getId(), professorObj.getName(), professorObj.getDepartmentId());

				return professor;
			}
		} catch (Exception ex) {
			throw ex;
		}

		return null;
	}
	
	@Override
	public void deleteProfessor(int professorId) {
		try {
			professorRepository.deleteById(professorId);
		} catch (Exception ex) {
			throw ex;
		}
	}
}
