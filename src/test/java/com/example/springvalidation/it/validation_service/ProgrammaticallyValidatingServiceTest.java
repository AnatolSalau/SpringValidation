package com.example.springvalidation.it.validation_service;

import com.example.springvalidation.entity.Input;
import com.example.springvalidation.validation_service.ProgrammaticallyValidatingService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ProgrammaticallyValidatingServiceTest {
      @Autowired
      private ProgrammaticallyValidatingService service;

      @Test
      void whenInputIsInvalid_thenThrowsException(){
            Input input = invalidInput();

            assertThrows(ConstraintViolationException.class, () -> {
                  service.validateInput(input);
            });
      }

      @Test
      void givenInjectedValidator_whenInputIsInvalid_thenThrowsException(){
            Input input = invalidInput();

            assertThrows(ConstraintViolationException.class, () -> {
                  service.validateInputWithInjectedValidator(input);
            });
      }

      private Input invalidInput() {
            Input input = new Input();
            input.setIpAddress("300.255.255.255");
            input.setNumberBetweenOneAndTen(10);
            return input;
      }
}