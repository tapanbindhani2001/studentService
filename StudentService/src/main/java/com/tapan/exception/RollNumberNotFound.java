package com.tapan.exception;

public class RollNumberNotFound extends RuntimeException {
    public RollNumberNotFound(Integer rollNo) {
        super(rollNo+" Not Found");
    }
}
