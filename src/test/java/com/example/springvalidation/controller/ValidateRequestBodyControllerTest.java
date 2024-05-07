package com.example.springvalidation.controller;

import com.example.springvalidation.dto.InputDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidateRequestBodyController.class)
class ValidateRequestBodyControllerTest {
      @Autowired
      private MockMvc mvc;
      @Autowired
      private  ObjectMapper objectMapper;

      @Test
      void whenInputIsInvalid_thenReturnsStatus400() throws Exception {
            InputDto input = validInput();
            String body = objectMapper.writeValueAsString(input);

            mvc.perform(MockMvcRequestBuilders.post("/validateBody")
                        .contentType("application/json")
                        .content(body))
                  .andExpect(MockMvcResultMatchers.status().isBadRequest());
      }

      private InputDto invalidInput() {
            InputDto input = new InputDto();
            input.setIpAddress("invalid");
            input.setNumberBetweenOneAndTen(99);
            return input;
      }

      private InputDto validInput() {
            InputDto input = new InputDto();
            input.setIpAddress("255.255.255.255");
            input.setNumberBetweenOneAndTen(10);
            return input;
      }
}