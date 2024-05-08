package com.example.springvalidation.exception_handler;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ValidationExceptionHandler {
      @ExceptionHandler(ConstraintViolationException.class)
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
            return new ResponseEntity<>(
                  "not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST
            );
      }

      @ExceptionHandler(RuntimeException.class)
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      ResponseEntity<String> handleRuntimeException(ConstraintViolationException e) {
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
            );
      }
}
