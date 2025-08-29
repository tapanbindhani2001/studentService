package com.tapan.service;

import com.tapan.entity.Student;
import com.tapan.entity.StudentDto;

public interface StudentService {

    StudentDto registerStudent(StudentDto student);
    StudentDto updateStudent(StudentDto student,Integer rollNo);
    StudentDto getStudent(Integer rollNo);
    Boolean deleteStudent(Integer rollNo);

}
