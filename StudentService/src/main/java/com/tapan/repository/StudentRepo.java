package com.tapan.repository;

import com.tapan.entity.Student;

public interface StudentRepo {

    Student saveStudent(Student student);

    Student getByRollNo(Integer rollNo);

    Boolean deleteStudent(Integer rollNo);

    Student updateStudent(Student student, Integer rollNo);
}