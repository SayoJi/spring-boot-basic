package com.sayo.girl.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    private Integer id;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "TEACHER_STUDENT",
            joinColumns =
            @JoinColumn(name = "TEACHER_ID", referencedColumnName = "ID", updatable = false, insertable = false),
            inverseJoinColumns =
            @JoinColumn(name = "STUDENT_ID", referencedColumnName = "ID", updatable = false, insertable = false))
    private Set<Student> students;

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
