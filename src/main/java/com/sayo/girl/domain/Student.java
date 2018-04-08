package com.sayo.girl.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {

    @Id
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "students")
    private Set<Teacher> teachers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers) {
        this.teachers = teachers;
    }
}
