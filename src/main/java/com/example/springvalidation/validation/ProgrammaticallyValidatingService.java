package com.example.springvalidation.validation;

import com.example.springvalidation.entity.Input;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
class ProgrammaticallyValidatingService {
      private Validator validator;

      @Autowired
      ProgrammaticallyValidatingService(Validator validator) {
            this.validator = validator;
      }

      void validateInputWithInjectedValidator(Input input) {
            Set<ConstraintViolation<Input>> violations = validator.validate(input);
            if (!violations.isEmpty()) {
                  throw new ConstraintViolationException(violations);
            }
      }

      void validateInput(Input input) {
            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<Input>> violations = validator.validate(input);
            if (!violations.isEmpty()) {
                  throw new ConstraintViolationException(violations);
            }
      }
}