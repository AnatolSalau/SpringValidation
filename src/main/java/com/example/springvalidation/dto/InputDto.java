package com.example.springvalidation.dto;

import com.example.springvalidation.annotation.IpAddress;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data

public class InputDto {
      private Long id;
      @Min(1)
      @Max(10)
      private int numberBetweenOneAndTen;

      @IpAddress
      private String ipAddress;
}
