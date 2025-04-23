package com.studies.schoolProject.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @PutMapping
    public ResponseEntity<Classes> insert(@RequestBody Classes obj) {
        classesService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        classesService.remove(id);
        return ResponseEntity.noContent().build();
    }
}
