package com.example.springvalidation.it.controller;

import com.example.springvalidation.controller.ValidateRequestBodyController;
import com.example.springvalidation.dto.InputDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidateRequestBodyController.class)
class ValidateRequestBodyControllerIntegrationTest {
      @Autowired
      private MockMvc mvc;
      @Autowired
      private ObjectMapper mapper;

      @Test
      void whenInputIsInvalid_thenReturnsStatus400() throws Exception {
            InputDto input = invalidInput();
            String body = mapper.writeValueAsString(input);

            mvc.perform(MockMvcRequestBuilders.post("/validateBody")
                        .contentType("application/json")
                        .content(body))
                  .andExpect(MockMvcResultMatchers.status().isBadRequest());
      }

      @Test
      void whenInputIsValid_thenReturnsStatus200() throws Exception {
            InputDto input = validInput();
            String body = mapper.writeValueAsString(input);

            mvc.perform(MockMvcRequestBuilders.post("/validateBody")
                        .contentType("application/json")
                        .content(body))
                  .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
      }

      private InputDto validInput() {
            InputDto input = new InputDto();
            input.setIpAddress("255.255.255.255");
            input.setNumberBetweenOneAndTen(10);
            return input;
      }

      private InputDto invalidInput() {
            InputDto input = new InputDto();
            input.setIpAddress("300.255.255.255");
            input.setNumberBetweenOneAndTen(10);
            return input;
      }
}