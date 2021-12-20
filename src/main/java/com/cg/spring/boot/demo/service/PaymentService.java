package com.cg.spring.boot.demo.service;

import java.util.List;

import javax.transaction.InvalidTransactionException;

import org.springframework.mail.MailException;

import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Payment;
import com.cg.spring.boot.demo.model.PaymentStatus;

public interface PaymentService {
	public PaymentStatus payBill(Payment payment) throws InvalidTransactionException;
	//public void sendEmailOnPaymentCompletion(String toEmail, String body, String subject) throws MailException ;
	public List<Payment> viewHistoricalPayment(Long consumerNumber)throws NoSuchCustomerException;
	Payment getPaymentById(Long paymentId) throws NoSuchCustomerException;
	List<Payment> getAllPayments();
	
	
}