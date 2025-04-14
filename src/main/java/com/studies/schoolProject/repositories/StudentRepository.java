package com.studies.schoolProject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studies.schoolProject.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

}
