package com.example.springvalidation.repository;

import com.example.springvalidation.entity.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface InputRepository extends JpaRepository<Input, Long> {
     List<Input> findAllByIpAddress(String ipAdress);
}