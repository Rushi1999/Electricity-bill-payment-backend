package com.cg.spring.boot.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import  com.cg.spring.boot.demo.model.Connection;

@Repository
public interface ConnectionRespository extends JpaRepository<Connection, Integer> {

  public List<Connection> getByPincode(int pincode);

public Object findByConsumerNumber(Long consumerNumber);

//public Object findBillByConsumerNumber(Long consumerNumber);
  
// public Optional<Connection> getConnectionByCustomerId(int connectionId);

}