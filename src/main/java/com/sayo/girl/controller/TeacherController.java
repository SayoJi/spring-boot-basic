package com.sayo.girl.controller;

import com.sayo.girl.domain.Teacher;
import com.sayo.girl.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @PostMapping(value = "/saveTeacher/{name}")
    public void saveTeacher(@PathVariable("name") String name) {

    }
}
