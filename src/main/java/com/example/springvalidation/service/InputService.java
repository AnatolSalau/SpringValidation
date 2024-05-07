package com.example.springvalidation.service;

import com.example.springvalidation.dto.InputDto;
import com.example.springvalidation.entity.Input;
import com.example.springvalidation.repository.InputRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
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

      private Input convertDtoToModel(InputDto inputDto) {
            Input map = mapper.map(inputDto, Input.class);
            return map;
      }

      private InputDto convertModelToDto(Input input) {
            InputDto map = mapper.map(input, InputDto.class);
            return map;
      }
}
