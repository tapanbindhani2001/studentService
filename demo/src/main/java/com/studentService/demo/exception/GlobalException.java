package com.studentService.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalException {
    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<ExceptionInfo> handleException(DataNotFoundException ex)
    {
          ExceptionInfo info = new ExceptionInfo();
          info.setCode("0X125FAILED");
          info.setDatatime(LocalDateTime.now());
          info.setMessage("Failed");
          info.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(info, HttpStatus.NOT_FOUND);
    }
}
