package com.cg.spring.boot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  com.cg.spring.boot.demo.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {


//	public Customer findByAadhar(Long aadharNumber);
public List<Customer> findByFirstName(String firstName) ;

public Customer findByMobileNumber(Long mobileNumber);

}