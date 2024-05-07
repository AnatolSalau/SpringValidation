package com.example.springvalidation.it.repository;

import com.example.springvalidation.dto.InputDto;
import com.example.springvalidation.entity.Input;
import com.example.springvalidation.repository.InputRepository;
import jakarta.persistence.EntityManager;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
class InputRepositoryIntegrationTest {
      @Autowired
      private InputRepository repository;

      @Autowired
      private EntityManager entityManager;

      @Test
      void whenInputIsInvalid_thenThrowsException() {
            Input input = invalidInput();

            assertThrows(ConstraintViolationException.class, () -> {
                  repository.save(input);
                  entityManager.flush();
            });
      }

      private Input invalidInput() {
            Input input = new Input();
            input.setId(100L);
            input.setIpAddress("invalid");
            input.setNumberBetweenOneAndTen(99);
            return input;
      }
}