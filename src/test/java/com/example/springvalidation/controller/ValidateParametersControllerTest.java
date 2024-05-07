package com.example.springvalidation.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ValidateParametersController.class)
class ValidateParametersControllerTest {
      @Autowired
      private MockMvc mvc;

      @Test
      void whenPathVariableIsInvalid_thenReturnsStatus400() throws Exception {
            ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/validatePathVariable/3"))
                  .andExpect(MockMvcResultMatchers.status().isBadRequest());
            System.out.println(resultActions);
      }

      @Test
      void whenRequestParameterIsInvalid_thenReturnsStatus400() throws Exception {
            mvc.perform(MockMvcRequestBuilders.get("/validateRequestParameter")
                        .param("param", "3"))
                  .andExpect(MockMvcResultMatchers.status().isBadRequest());
      }
}