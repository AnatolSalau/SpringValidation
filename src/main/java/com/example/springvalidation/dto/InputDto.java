package com.example.springvalidation.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data

public class InputDto {
      @Min(1)
      @Max(10)
      private int numberBetweenOneAndTen;

      @Pattern(regexp = "^[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}$")
      private String ipAddress;
}
