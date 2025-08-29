package com.tapan.entity;

import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {


   // @NotNull
   // @NotBlank
    private String name;

    @Indexed(unique = true)
    private  Integer rollNo;
}
