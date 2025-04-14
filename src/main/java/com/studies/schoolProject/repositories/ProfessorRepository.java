package com.studies.schoolProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.schoolProject.entities.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{

}
