package com.studies.schoolProject.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studies.schoolProject.entities.Classes;
import com.studies.schoolProject.services.ClassesService;

@RestController
@RequestMapping(path = "/classes")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    @GetMapping
    public ResponseEntity<List<Classes>> findAll() {
        return ResponseEntity.ok().body(classesService.findAll());
    }

    @GetMapping(value = "/{id}") 
    public ResponseEntity<Classes> findById(@PathVariable Long id) {
        Classes obj = classesService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
