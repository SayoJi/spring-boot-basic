package com.sayo.girl.service;

import com.sayo.girl.domain.Student;
import com.sayo.girl.domain.Teacher;
import com.sayo.girl.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Shuangyao
 * 22:24 2018/3/15
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    /**
     * Test ManyToMany table save
     */
    @Transactional
    public Teacher setData() {
        Student student1 = new Student();
        student1.setName("Ly");
        Student student2 = new Student();
        student2.setName("Sayo");
        Student student3 = new Student();
        student3.setName("Lisa");
        Student student4 = new Student();
        student4.setName("Sayo");
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        Teacher teacher = new Teacher();
        teacher.setName("teacher1");
        teacher.setStudents(students);

        return this.teacherRepository.save(teacher);
    }
}
