package com.example.springvalidation.it.validation_service;

import com.example.springvalidation.dto.InputDto;
import com.example.springvalidation.validation_service.InputValidatingService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class InputValidatingServiceIntegrationTest {
      @Autowired
      private InputValidatingService service;

      @Test
      void whenInputIsInvalid_thenThrowsException(){
            InputDto input = invalidInput();

            Assertions.assertThrows(ConstraintViolationException.class, () -> {
                  service.validateInput(input);
            });
      }

      private InputDto invalidInput() {
            InputDto input = new InputDto();
            input.setIpAddress("invalid");
            input.setNumberBetweenOneAndTen(99);
            return input;
      }
}