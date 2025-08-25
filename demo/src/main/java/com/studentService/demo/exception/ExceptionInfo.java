package com.studentService.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
@Data
public class ExceptionInfo {
    private String code;
    private String message;
    private LocalDateTime datatime;
    private HttpStatus status;

}
