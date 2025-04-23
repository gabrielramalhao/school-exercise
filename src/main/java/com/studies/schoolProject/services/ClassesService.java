package com.studies.schoolProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.schoolProject.entities.Classes;
import com.studies.schoolProject.repositories.ClassesRepository;

@Service
public class ClassesService {

    @Autowired
    private ClassesRepository classesRepository;

    public List<Classes> findAll() {
        return classesRepository.findAll();
    }

    public Classes findById(long id) {
        var obj = classesRepository.findById(id);
        return obj.get();
    }

    public Classes insert(Classes obj) {
        classesRepository.save(obj);
        return obj;
    }

    public void remove(long id) {
        classesRepository.deleteById(id);
    }

    
}
