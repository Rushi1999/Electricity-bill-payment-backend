package com.cg.spring.boot.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.spring.boot.demo.model.Payment;
import com.cg.spring.boot.demo.model.PaymentMode;
import com.cg.spring.boot.demo.model.PaymentStatus;



@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

//	Optional<Payment> findById(Payment payment);

//	Optional<Payment> exists(Long consumerNumber);
	
	@Query(name = "SELECT c FROM Customer c WHERE c.bill.Connection.consumerNumber = ?1")
	public abstract List<Payment> findByConsumerNumber(int consumerNumber);

//	List<Payment> findAllById(Long consumerNumber);
	
	public Payment findByPaymentId(Long partyId);
//	PaymentStatus getStatus();

//	boolean exists(Payment payment);
//
//	boolean existByPaymentId(Long paymentId);

	
}