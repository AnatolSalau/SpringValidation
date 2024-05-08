package com.example.springvalidation.exception_handler;

import com.example.springvalidation.violation.ValidationErrorResponse;
import com.example.springvalidation.violation.Violation;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ValidationExceptionHandler {
      @ExceptionHandler(ConstraintViolationException.class)
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      ResponseEntity<ValidationErrorResponse> onConstraintValidationException(
            ConstraintViolationException e) {

            List<Violation> violations = e.getConstraintViolations().stream()
                  .map(constraintViolation -> new Violation(
                        constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage())
                  )
                  .toList();
            return new ResponseEntity<>(new ValidationErrorResponse(violations), HttpStatus.BAD_REQUEST);
      }

      @ExceptionHandler(MethodArgumentNotValidException.class)
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      ResponseEntity<ValidationErrorResponse> onMethodArgumentNotValidException(
            MethodArgumentNotValidException e) {

            List<Violation> violations = e.getBindingResult().getFieldErrors().stream()
                  .map(fieldError -> new Violation(
                        fieldError.getField(), fieldError.getDefaultMessage())
                  )
                  .toList();

            return new ResponseEntity<>(new ValidationErrorResponse(violations), HttpStatus.BAD_REQUEST);
      }

      @ExceptionHandler(RuntimeException.class)
      @ResponseStatus(HttpStatus.BAD_REQUEST)
      ResponseEntity<String> handleRuntimeException(ConstraintViolationException e) {
            return new ResponseEntity<>(
                  e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
            );
      }
}
