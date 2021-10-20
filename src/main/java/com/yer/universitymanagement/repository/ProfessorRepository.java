package com.yer.universitymanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yer.universitymanagement.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
