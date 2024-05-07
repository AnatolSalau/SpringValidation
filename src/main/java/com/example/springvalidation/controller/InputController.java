package com.example.springvalidation.controller;

import com.example.springvalidation.dto.InputDto;
import com.example.springvalidation.service.InputService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InputController {

      private final InputService inputService;

      public InputController(InputService inputService) {
            this.inputService = inputService;
      }

      @PostMapping("/input")
      ResponseEntity<InputDto> validateBody(@Valid @RequestBody InputDto input) {
            InputDto inputDto = inputService.saveInput(input);
            return ResponseEntity.ok(inputDto);
      }
}
