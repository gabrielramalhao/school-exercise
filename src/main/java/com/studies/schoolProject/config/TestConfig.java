package com.studies.schoolProject.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.studies.schoolProject.entities.Professor;
import com.studies.schoolProject.repositories.ProfessorRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private ProfessorRepository professorRepository;

    @Override
    public void run(String... args) throws Exception {
        
        Professor p1 = new Professor(null, "Germano Collins");
        Professor p2 = new Professor(null, "Caroline Finning");

        professorRepository.saveAll(Arrays.asList(p1, p2));
    }


}
