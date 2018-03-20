package com.sayo.girl.service;

import com.sayo.girl.domain.Student;
import com.sayo.girl.domain.Teacher;
import com.sayo.girl.repository.StudentRepository;
import com.sayo.girl.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Shuangyao
 * 22:24 2018/3/15
 */
@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private StudentRepository studentRepository;

    /**
     * Test ManyToMany table save
     */
    @Transactional
    public void setData() {
        //save teacher
        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Ly");
        Student student2 = new Student();
        student2.setId(2);
        student2.setName("Sayo");

        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);

        Teacher teacher = new Teacher();
        teacher.setId(11);
        teacher.setName("teacher1");
        teacher.setStudents(students);
        this.teacherRepository.save(teacher);

        //save student
        Teacher teacher1 = new Teacher();
        teacher.setId(22);
        Set<Teacher> teachers = new HashSet<>();
        teachers.add(teacher1);

        Student student3 = new Student();
        student3.setId(3);
        student3.setName("Lisa");
        student3.setTeachers(teachers);
        this.studentRepository.save(student3);

        Teacher teacher2 = new Teacher();
        teacher2.setId(33);
        teacher2.setName("teacher2");
        teacher2.setStudents(students);
        this.teacherRepository.save(teacher2);
    }

    @Transactional
    public Student queryStudentById(Integer id){
        return this.studentRepository.findOne(id);
    }
}
