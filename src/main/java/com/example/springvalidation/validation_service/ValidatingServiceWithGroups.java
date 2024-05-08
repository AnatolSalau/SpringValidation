package com.example.springvalidation.validation_service;

import com.example.springvalidation.dto.InputDtoWithGroups;
import com.example.springvalidation.marker_interface.OnCreate;
import com.example.springvalidation.marker_interface.OnUpdate;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class ValidatingServiceWithGroups {

    @Validated(OnCreate.class)
    public void validateForCreate(@Valid InputDtoWithGroups input){
      // do something
    }

    @Validated(OnUpdate.class)
    public void validateForUpdate(@Valid InputDtoWithGroups input){
      // do something
    }

}