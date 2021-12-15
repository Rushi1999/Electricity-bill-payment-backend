package com.cg.spring.boot.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.Payment;



@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//	Optional<Payment> findById(Payment payment);

//	Optional<Payment> exists(Long consumerNumber);
	
//	@Query(value = "SELECT c FROM Customer c WHERE c.Bill.Reading.Connection.consumerNumber = ?1")
//	public List<Payment> findByConsumerNumber(Long consumerNumber);
	public abstract List<Payment> findByCustomer_customerId(Long customerId);

//	List<Payment> findAllById(Long consumerNumber);
	
	
	public Payment findByPaymentId(Long paymentId);
//	PaymentStatus getStatus();

//	boolean exists(Payment payment);
//
//	boolean existByPaymentId(Long paymentId);

	
}