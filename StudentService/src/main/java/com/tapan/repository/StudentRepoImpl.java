package com.tapan.repository;


import com.tapan.entity.Student;
import com.tapan.exception.RollNumberNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public class StudentRepoImpl implements  StudentRepo{

    @Autowired
    private MongoTemplate template;

    @Override
    public Student saveStudent(Student student) {
        return template.insert(student);
    }



    @Override
    public Student getByRollNo(Integer rollNo) {
        return Optional.ofNullable(template.findOne(new Query().addCriteria(Criteria.where("rollNo").is(rollNo)),Student.class)).orElseThrow(()->new RollNumberNotFound(rollNo));
    }

    @Override
    public Boolean deleteStudent(Integer rollNo) {
        Student student=getByRollNo(rollNo);
        template.remove(student);
        return true;
    }

    @Override
    public Student updateStudent(Student student,Integer rollNo) {
        Query query=new Query();
        query.addCriteria(Criteria.where("rollNo").is(rollNo));
        Update update=new Update();
        update.set("name",student.getName());
        update.set("rollNo",student.getRollNo());
        template.updateFirst(query,update,Student.class);
        return getByRollNo(rollNo);
    }



}
