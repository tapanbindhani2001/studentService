package com.studentService.demo.service;

import com.studentService.demo.entity.Student;
import com.studentService.demo.repository.StudentRepo;

import java.util.List;

public interface StudentService {
    public List<Student> getAll();
    public Student getById(String id);
    public Student addStudent(Student student);
    public void deleteStudent(String id);
    public Student updateStudent(String id,Student student);
}
