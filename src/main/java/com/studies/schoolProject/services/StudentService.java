package com.studies.schoolProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.schoolProject.entities.Student;
import com.studies.schoolProject.repositories.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(long id) {
        var obj = studentRepository.findById(id);
        return obj.get();
    }

    public void remove(long id) {
        studentRepository.deleteById(id);
    }

    public void insert(Student student) {
        studentRepository.save(student);
    }

    public Student update(Student obj, long id) {
        var entity = studentRepository.getReferenceById(id);
        updateData(entity, obj);
        return studentRepository.save(entity);
    }

    private void updateData(Student entity, Student obj) {
        entity.setName(obj.getName());
        entity.setProfessor(obj.getProfessor());
        entity.setClasses(obj.getClasses());
    }
}
