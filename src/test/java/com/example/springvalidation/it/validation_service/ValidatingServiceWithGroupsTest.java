package com.example.springvalidation.it.validation_service;

import com.example.springvalidation.dto.InputDtoWithGroups;
import com.example.springvalidation.entity.Input;
import com.example.springvalidation.validation_service.ValidatingServiceWithGroups;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class ValidatingServiceWithGroupsTest {
      @Autowired
      private ValidatingServiceWithGroups service;

      @Test
      void whenInputIsInvalidForCreate_thenThrowsException() {
            InputDtoWithGroups input = returnValidInput();
            input.setId(42L);

            assertThrows(ConstraintViolationException.class, () -> {
                  service.validateForCreate(input);
            });
      }

      @Test
      void whenInputIsInvalidForUpdate_thenThrowsException() {
            InputDtoWithGroups input = returnValidInput();
            input.setId(null);

            assertThrows(ConstraintViolationException.class, () -> {
                  service.validateForUpdate(input);
            });
      }

      private InputDtoWithGroups returnValidInput() {
            InputDtoWithGroups input1 = new InputDtoWithGroups();
            input1.setId(1L);
            input1.setIpAddress("127.0.0.1");
            input1.setNumberBetweenOneAndTen(1);
            return input1;
      }
}