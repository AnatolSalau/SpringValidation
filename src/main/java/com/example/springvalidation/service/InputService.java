package com.example.springvalidation.service;

import com.example.springvalidation.annotation.IpAddress;
import com.example.springvalidation.dto.InputDto;
import com.example.springvalidation.entity.Input;
import com.example.springvalidation.repository.InputRepository;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class InputService {
      private final InputRepository repository;
      private final ModelMapper mapper;

      @Autowired
      public InputService(InputRepository repository, ModelMapper mapper) {
            this.repository = repository;
            this.mapper = mapper;
      }

      public InputDto saveInput(InputDto inputDto) {
            Input save = repository.save(convertDtoToModel(inputDto));
            return convertModelToDto(save);
      }

      @NotNull
      @Size(min = 1)
      public List<@NotNull InputDto> findAllUser() {
            List<Input> result = repository.findAll();
            return result.stream()
                  .map(input -> mapper.map(
                        input, InputDto.class)
                  )
                  .toList();
      }

      @NotNull
      @Size(min = 1)
      public List<@NotNull InputDto> findAllUsersByIpAddress(@NotEmpty String ipAdress) {
            List<Input> result = repository.findAllByIpAddress(ipAdress);
            return result.stream()
                  .map(input -> mapper.map(
                        input, InputDto.class)
                  )
                  .toList();
      }

      @NotEmpty
      @IpAddress
      public String getInputIpAdressByInputId( Long id) {
            Optional<Input> byId = repository.findById(id);
            Input input = byId.orElseThrow(
                  () -> new RuntimeException("Input not found")
            );
            return input.getIpAddress();
      }

      private Input convertDtoToModel(InputDto inputDto) {
            Input map = mapper.map(inputDto, Input.class);
            return map;
      }

      private InputDto convertModelToDto(Input input) {
            InputDto map = mapper.map(input, InputDto.class);
            return map;
      }


}
