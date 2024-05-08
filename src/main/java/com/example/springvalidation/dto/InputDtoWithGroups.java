package com.example.springvalidation.dto;

import com.example.springvalidation.annotation.IpAddress;
import com.example.springvalidation.marker_interface.OnCreate;
import com.example.springvalidation.marker_interface.OnUpdate;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data

public class InputDtoWithGroups {
      @Null(groups = OnCreate.class)
      @NotNull(groups = OnUpdate.class)
      private Long id;

      @Min(1)
      @Max(10)
      private int numberBetweenOneAndTen;

      @IpAddress
      private String ipAddress;
}
