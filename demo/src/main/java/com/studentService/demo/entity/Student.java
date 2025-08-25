package com.studentService.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Student {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private Integer rollno;
    private String email;
    private String mob;

}
