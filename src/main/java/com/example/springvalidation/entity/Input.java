package com.example.springvalidation.entity;

import com.example.springvalidation.annotation.IpAddress;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

@Entity
public class Input {

      @Id
      @GeneratedValue
      private Long id;

      @Min(1)
      @Max(10)
      private int numberBetweenOneAndTen;

      @IpAddress
      private String ipAddress;
}