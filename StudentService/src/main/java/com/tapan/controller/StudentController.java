package com.tapan.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tapan.entity.StudentDto;
import com.tapan.service.KafkaService;
import com.tapan.service.StudentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @Autowired
    private KafkaService kafkaService;

    private static Logger logger= LoggerFactory.getLogger(StudentController.class);


    @PostMapping("/")
    public ResponseEntity<StudentDto> createStudent(@Valid @RequestBody StudentDto student) throws JsonProcessingException {

        ResponseEntity<StudentDto> response=new ResponseEntity<>(service.registerStudent(student), HttpStatus.CREATED) ;
        kafkaService.notifyService("Student Create API Called!!!");
        kafkaService.notifyService2("Student Created");
        return response;
    }


    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@Valid @RequestBody StudentDto student, @PathVariable Integer id) throws JsonProcessingException {

        ResponseEntity<StudentDto> response=new ResponseEntity<>(service.updateStudent(student,id), HttpStatus.ACCEPTED) ;
        kafkaService.notifyService("student Update API Called");
        return response;
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> createStudent( @PathVariable Integer id) throws JsonProcessingException {

        ResponseEntity<Boolean> response=new ResponseEntity<>(service.deleteStudent(id), HttpStatus.NO_CONTENT) ;
        kafkaService.notifyService("Student Delete API Called");
        return response;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudent(@PathVariable Integer id) throws JsonProcessingException {
        ResponseEntity<StudentDto> response=new ResponseEntity<>(service.getStudent(id), HttpStatus.FOUND) ;
        kafkaService.notifyService("Get Student API Called");
        return response;
    }


    @PostMapping("/verify")
    public ResponseEntity<Void> getVerification(@RequestBody String veriffication){
        logger.info(veriffication);
        return ResponseEntity.ok().build();
    }



}
