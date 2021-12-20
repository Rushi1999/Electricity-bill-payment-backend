package com.cg.spring.boot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.Payment;



@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	@Query("select u from Payment u where u.customer=:n")
	public abstract List<Payment> getListBycustomerId(@Param("n")Long customerId);
	
}