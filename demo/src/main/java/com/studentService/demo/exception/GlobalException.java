package com.studentService.demo.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.io.EOFException;
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
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Invalid path variable: " + ex.getValue());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex, HttpServletRequest request) {
        ex.printStackTrace(); // Logs for debugging
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong: " + ex.getMessage());
    }



    @ExceptionHandler(EOFException.class)
    public ResponseEntity<String> EOFExceptionHandler(Exception ex, HttpServletRequest request) {
        ex.printStackTrace(); // Logs for debugging
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong: " + ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> IllegalArgumentExceptionHandler(Exception e) {
   return new  ResponseEntity<>("Not a Valid URL",HttpStatus.BAD_REQUEST);
    }


}
