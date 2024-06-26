package com.example.springvalidation.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class CustomerDto {
      @Email
      private String email;

      @NotBlank
      private String name;
}
