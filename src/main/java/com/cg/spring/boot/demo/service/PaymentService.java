package com.cg.spring.boot.demo.service;

import java.util.List;

import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Payment;
import com.cg.spring.boot.demo.model.PaymentStatus;

public interface PaymentService {
		
//	public PaymentStatus payBill(Payment payment);
	public void sendEmailOnPaymentCompletion(Long paymentId, String email);
	
//	public List<Payment> viewHistoricalPayment(Long paymentId) throws NoSuchCustomerException;
	
	public PaymentStatus payBill(Long paymentId) throws NoSuchCustomerException;
	
	public List<Payment> viewHistoricalPayment(Long consumerNumber) throws NoSuchCustomerException;
	 
}