package com.example.springvalidation.it.service;


import com.example.springvalidation.dto.InputDto;
import com.example.springvalidation.entity.Input;
import com.example.springvalidation.repository.InputRepository;


import com.example.springvalidation.service.InputService;
import jakarta.validation.ConstraintViolationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class InputServiceTest {
      @MockBean
      InputRepository repository;

      @Autowired
      private InputService inputService;

      @Test
      void whenReturnListIsNull_thenThrowException() {
            when(repository.findAll())
                  .thenReturn(returnEmptyInputList());

            Assertions.assertThrows(
                  ConstraintViolationException.class,inputService::findAllUser
            );
      }

      @Test
      void whenIpAdressIsDone_thenReturnList() {
            String ipAdress = "128.0.0.1";
            when(repository.findAllByIpAddress(ipAdress))
                  .thenReturn(returnTwoInputs());
            List<InputDto> allByIpAddress = inputService.findAllUsersByIpAddress(ipAdress);
            Assertions.assertEquals(2,allByIpAddress.size());
      }

      @Test
      void whenIpAdressIsNull_thenThrowException() {
            String ipAdress = null;
            when(repository.findAllByIpAddress(ipAdress))
                  .thenReturn(returnTwoInputs());
            Assertions.assertThrows(
                  ConstraintViolationException.class,() -> {
                        inputService.findAllUsersByIpAddress(ipAdress);
                  }
            );
      }

      @Test
      void whenIpAdressIsEmpty_thenThrowException() {
            String ipAdress = "";
            when(repository.findAllByIpAddress(ipAdress))
                  .thenReturn(returnTwoInputs());
            Assertions.assertThrows(
                  ConstraintViolationException.class,() -> {
                        inputService.findAllUsersByIpAddress(ipAdress);
                  }
            );
      }

      @Test
      void whenResulListContainNull_thenThrowException() {
            String ipAdress = "127.0.0.1";
            when(repository.findAllByIpAddress(ipAdress))
                  .thenReturn(returnListInputsWithOneNull());
            Assertions.assertThrows(
                  IllegalArgumentException.class,() -> {
                        inputService.findAllUsersByIpAddress(ipAdress);
                  }
            );
      }

      private List<Input> returnEmptyInputList() {
            List<Input> result = new ArrayList<>();
            return result;
      }

      private List<Input> returnTwoInputs() {
            Input input1 = new Input();
            input1.setId(1L);
            input1.setIpAddress("127.0.0.1");
            input1.setNumberBetweenOneAndTen(1);

            Input input2 = new Input();
            input2.setId(2L);
            input2.setIpAddress("127.0.0.1");
            input2.setNumberBetweenOneAndTen(2);

            List<Input> result = List.of(input1, input2);
            return result;
      }

      private List<Input> returnListInputsWithOneNull() {
            Input input1 = new Input();
            input1.setId(1L);
            input1.setIpAddress("127.0.0.1");
            input1.setNumberBetweenOneAndTen(1);

            Input input2 = new Input();
            input2.setId(2L);
            input2.setIpAddress("127.0.0.1");
            input2.setNumberBetweenOneAndTen(2);

            List<Input> result = new ArrayList<>();
            result.add(input1);
            result.add(input2);
            result.add(null);
            return result;
      }
}