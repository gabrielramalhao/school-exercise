package com.studies.schoolProject.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studies.schoolProject.entities.Professor;
import com.studies.schoolProject.repositories.ProfessorRepository;

@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    public Professor findById(long id) {
        var obj = professorRepository.findById(id);
        return obj.get();
    }

    public void remove(long id) {
        professorRepository.deleteById(id);
    }

    public Professor insert(Professor obj) {
        return professorRepository.save(obj);
    }

    public Professor update(long id, Professor obj) {
        var entity = professorRepository.getReferenceById(id);
        updateData(entity, obj);
        return professorRepository.save(entity);
    }

    private void updateData(Professor entity, Professor obj) {
        entity.setName(obj.getName());
    }
}
