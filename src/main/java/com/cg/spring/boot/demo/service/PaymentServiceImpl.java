package com.cg.spring.boot.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.InvalidTransactionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Payment;
import com.cg.spring.boot.demo.model.PaymentStatus;
import com.cg.spring.boot.demo.repository.PaymentRepository;


@Service("paymentservice")
public class PaymentServiceImpl implements PaymentService {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentServiceImpl.class);

	@Autowired
	private PaymentServiceImpl paymentService;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
//	@Autowired
//	private JavaMailSender javaMailSender;
	
	
	@Override
	public Payment getPaymentById(Long paymentId) throws NoSuchCustomerException {
		LOG.info("get PaymentId ById");
			Optional<Payment> connection = paymentRepository.findById(paymentId);
			if (connection.isPresent()) {
				LOG.info("PaymentId is available.");
				return connection.get();
			} else {
				LOG.error("PaymentId is NOT available.");
				throw new NoSuchCustomerException(paymentId + " this paymentId is not found.");
			}		

	}	
	
	@Override
	  public List<Payment>getAllPayments() {
			System.out.println("Service getAllPayment");
			return paymentRepository.findAll();
		}
	  
	
	
	@Override
	public PaymentStatus payBill(Payment payment) throws InvalidTransactionException {
		LOG.info(" Pay-Bills ");
		boolean pay = paymentRepository.existsById(payment.getPaymentId());
		if(pay) {
			LOG.info("Payment initiated");
			return ((paymentRepository.save(payment)).getStatus());
		}
		else {
			LOG.info("paymentId not found in Database");
			throw new InvalidTransactionException("Payment is failed due to Invalid details");
		}
		
	}

//	public void sendEmailOnPaymentCompletion(String toEmail, String body, String subject) throws MailException {
//		SimpleMailMessage simpleMail = new SimpleMailMessage();
//		
//		simpleMail.setTo(toEmail);
//		simpleMail.setSubject(subject);
//		simpleMail.setText(body);
//		simpleMail.setFrom("e.billpayment.sprint1@gmail.com");
//		
//		javaMailSender.send(simpleMail);
//		LOG.info("Mail send...");
//		
//	}
//	
//	@EventListener(ApplicationReadyEvent.class)
//	public void triggerMail() {
//		paymentService.sendEmailOnPaymentCompletion("e.billpayment.sprint1@gmail.com", 
//				"Thankyou for paying bill and you have won the gift coin ", "Bill paymentment");
//		
//	}
	
	
	@Override
	public List<Payment> viewHistoricalPayment(Long customerId) throws NoSuchCustomerException {
		LOG.info("Get all paymentHistory ");
		boolean pay = paymentRepository.existsById(customerId);
		if(pay){
		LOG.info("customer Id found ");
		return paymentRepository.getListBycustomerId(customerId);
	} else {
		LOG.info("farmer ID not found");
		throw new NoSuchCustomerException ("CustomerId not found");
	}
}
	
}