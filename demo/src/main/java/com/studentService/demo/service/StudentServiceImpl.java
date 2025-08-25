package com.studentService.demo.service;

import com.studentService.demo.entity.Student;
import com.studentService.demo.exception.DataNotFoundException;
import com.studentService.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentRepo repo;
    @Override
    public List<Student> getAll() {
        return repo.findAll();
    }

    @Override
    public Student getById(String id) {
        return repo.findById(id).orElseThrow(()->new DataNotFoundException("Record Not Found On Server"));
    }

    @Override
    public Student addStudent(Student student) {
        return repo.save(student);
    }

    @Override
    public void deleteStudent(String id) {
        repo.deleteById(id);

    }

    @Override
    public Student updateStudent(String id, Student student) {
        Student std=repo.findById(id).orElseThrow(()->new DataNotFoundException("Record Not Found On Server"));
        std.setName(student.getName());
        std.setEmail(student.getEmail());
        repo.save(std);
        return std;

    }
}
