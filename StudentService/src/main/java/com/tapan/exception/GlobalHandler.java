package com.tapan.exception;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(RollNumberNotFound.class)
    public ResponseEntity<ApiResponse> rollNoNotFoundHandler(Exception e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(),false), HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(MissingPathVariableException.class)
    public ResponseEntity<ApiResponse> MissingPathVariableExceptionHandler(Exception e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(),false), HttpStatus.NOT_ACCEPTABLE);
    }





    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> NotValidException(MethodArgumentNotValidException e){
        Map<String, String> errorResponse=new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error)->{
            String fieldName=((FieldError)error).getField();
            String errorMessge=error.getDefaultMessage();

            errorResponse.put(fieldName, errorMessge);

        });
        return new ResponseEntity<Map<String,String>>(errorResponse,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(DuplicateKeyException.class)
    public ResponseEntity<ApiResponse> DuplicateKeyExceptionHandler(Exception e){
        return new ResponseEntity<>(new ApiResponse("Duplicated Key Found,Roll Number Must be Unique!!",false), HttpStatus.NOT_ACCEPTABLE);
    }


    @ExceptionHandler(JsonProcessingException.class)
    public  ResponseEntity<ApiResponse> JsonProcessingExceptionHandler(Exception e){
        return new ResponseEntity<>(new ApiResponse(e.getMessage(),false),HttpStatus.INTERNAL_SERVER_ERROR);
    }







}
