package com.example.springvalidation.violation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class ValidationErrorResponse {

  private List<Violation> violations;

}