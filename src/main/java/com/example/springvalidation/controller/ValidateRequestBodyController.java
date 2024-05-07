package com.example.springvalidation.controller;

import com.example.springvalidation.dto.InputDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public
class ValidateRequestBodyController {

      @PostMapping("/validateBody")
      ResponseEntity<String> validateBody(@Valid @RequestBody InputDto input) {

            return ResponseEntity.ok("valid");
      }

}