package com.studies.schoolProject.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.studies.schoolProject.entities.Student;
import com.studies.schoolProject.services.StudentService;

@RestController
@RequestMapping(path = "/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        var obj = studentService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Student> insert(@RequestBody Student obj) {
        studentService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        studentService.remove(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student obj) {
        studentService.update(obj, id);
        return ResponseEntity.ok().body(obj);
    }
}
