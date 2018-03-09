package com.sayo.girl.repository;

import com.sayo.girl.domain.Student;
import com.sayo.girl.domain.Teacher;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    private void setData() {
        Student student1 = new Student();
        student1.setName("student_name1");
        Student student2 = new Student();
        student2.setName("student_name2");
        Student student3 = new Student();
        student3.setName("student_name3");
        Student student4 = new Student();
        student4.setName("student_name4");
        Set<Student> students = new HashSet<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        Teacher teacher = new Teacher();
        teacher.setName("teacher1");
        teacher.setStudents(students);

        this.teacherRepository.save(teacher);
    }

    @Test
    public void findById() {
        setData();

        Teacher teacher = this.teacherRepository.findById(1);

        Assert.assertEquals(teacher.getStudents().size(), 4);
    }
}