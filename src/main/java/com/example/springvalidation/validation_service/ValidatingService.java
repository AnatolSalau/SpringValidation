package com.example.springvalidation.validation_service;

import com.example.springvalidation.dto.InputDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
class ValidatingService{

    void validateInput(@Valid InputDto input){
      // do something
    }

}