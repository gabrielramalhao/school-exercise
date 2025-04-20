package com.studies.schoolProject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.studies.schoolProject.entities.Classes;
import com.studies.schoolProject.entities.Professor;
import com.studies.schoolProject.entities.Student;
import com.studies.schoolProject.repositories.ClassesRepository;
import com.studies.schoolProject.repositories.ProfessorRepository;
import com.studies.schoolProject.repositories.StudentRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private ClassesRepository classesRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Professor p1 = new Professor(null, "Germano Collins");
        Professor p2 = new Professor(null, "Caroline Finning");

        Classes c1 = new Classes(null, "Portuguese", p2);
        Classes c2 = new Classes(null, "Chemistry", p1);

        Student s1 = new Student(null, "Karen Rodgers", p2, c2);
        Student s2 = new Student(null, "Hank Lavine", p1, c1);
       
        classesRepository.saveAll(Arrays.asList(c1, c2));
        studentRepository.saveAll(Arrays.asList(s1, s2));
        professorRepository.saveAll(Arrays.asList(p1, p2));
    }


}
