package com.sayo.girl.controller;

import com.sayo.girl.domain.Student;
import com.sayo.girl.domain.Teacher;
import com.sayo.girl.repository.StudentRepository;
import com.sayo.girl.repository.TeacherRepository;
import com.sayo.girl.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * Test ManyToMany Table.
     * successful! good job.
     * can see data connection information in the table teacher_student which auto create by hibernate.
     *
     * @return
     */
    @PostMapping(value = "/saveTeacher")
    public void saveTeacher() {
        this.teacherService.setData();
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/student")
    public Student queryStudentById(@RequestParam("id") Integer id) {
        return this.studentRepository.findOne(id);
    }

    @GetMapping(value = "/getTeacher/{id}")
    public Teacher getTeacher(@PathVariable("id") Integer id){
        return teacherRepository.findOne(id);
    }
}
