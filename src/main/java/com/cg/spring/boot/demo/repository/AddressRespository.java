package com.cg.spring.boot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  com.cg.spring.boot.demo.model.Address;

@Repository
public interface  AddressRespository<Connection> extends JpaRepository<Address, Long> {

	public List<Connection> findByPincode(Long pincode);
	
}
