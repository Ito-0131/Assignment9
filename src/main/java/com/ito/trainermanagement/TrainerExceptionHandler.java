package com.ito.trainermanagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class TrainerExceptionHandler {
    @ExceptionHandler(TrainerNotFoundException.class)
    public ResponseEntity<?> handleTrainerNotFoundException(TrainerNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}
