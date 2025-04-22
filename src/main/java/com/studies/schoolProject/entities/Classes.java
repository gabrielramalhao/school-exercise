package com.studies.schoolProject.entities;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_classes")
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class Classes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    private String className;

    public Classes(Long id, String className, Professor professor) {
        this.id = id;
        this.className = className;
        this.professor = professor;
    }

    @JsonIgnore
    @OneToOne
    @MapsId
    private Professor professor;

    @JsonIgnore
    @OneToMany(mappedBy = "classes")
    private List<Student> students = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
