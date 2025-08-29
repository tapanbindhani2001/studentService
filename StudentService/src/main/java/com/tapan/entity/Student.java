package com.tapan.entity;
<<<<<<< HEAD

=======
>>>>>>> 782294ee766d76d84d0e97f0c908b3400dca68a8
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Student {

    @Id
    private String _id;

    private String name;

    @Indexed(unique = true)
    private  Integer rollNo;




}
