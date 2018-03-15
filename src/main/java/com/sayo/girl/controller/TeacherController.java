package com.sayo.girl.controller;

import com.sayo.girl.domain.Teacher;
import com.sayo.girl.repository.TeacherRepository;
import com.sayo.girl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    /**
     * Test ManyToMany Table.
     * successful! good job.
     * @return
     */
    @PostMapping(value = "/saveTeacher")
    public Teacher saveTeacher() {
        return this.teacherService.setData();
    }
}
