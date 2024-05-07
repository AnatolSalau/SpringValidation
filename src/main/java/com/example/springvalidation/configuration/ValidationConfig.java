package com.example.springvalidation.configuration;

import jakarta.validation.Validation;
import jakarta.validation.executable.ExecutableValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValidationConfig {
      @Bean
      public ExecutableValidator executableValidator() {
            ExecutableValidator executableValidator = Validation
                  .buildDefaultValidatorFactory().getValidator().forExecutables();
            return executableValidator;
      }
}
