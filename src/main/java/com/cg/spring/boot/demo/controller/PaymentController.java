package com.cg.spring.boot.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Payment;
import com.cg.spring.boot.demo.model.PaymentStatus;

import com.cg.spring.boot.demo.service.PaymentServiceImpl;


@Component
@RestController
public class PaymentController {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentServiceImpl paymentService;

	@GetMapping("getPaymentStatus")
	public ResponseEntity<PaymentStatus> payBill(@RequestBody Long paymentId) {
		LOG.info("getPaymentById");
		PaymentStatus payment1 = paymentService.payBill(paymentId); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This payBill is success.");
		LOG.info(headers.toString());
		ResponseEntity<PaymentStatus> response = new ResponseEntity<PaymentStatus>(payment1, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping(path = "/readhistoricalpayment/{consumernumber}")
	public ResponseEntity<List<Payment>> readHistoricalPayment(
			@PathVariable(name = "consumernumber") int consumerNumber) throws NoSuchCustomerException// throws NoSuchCustomerException
	{
		LOG.info("readHistoricalPayment");
		List<Payment> list = paymentService.viewHistoricalPayment(consumerNumber);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "FeedBack added to database");
		ResponseEntity<List<Payment>> response = new ResponseEntity<>(list, headers, HttpStatus.CREATED);
		return response;

	}

	//
//	public ResponseEntity<Void> sendEmailOnPaymentCompletion(@RequestBody Long paymentId, String email) {
//		LOG.info("sendEmailOnPaymentCompletion");
//		long payment = paymentService.sendEmailOnPaymentCompletion(paymentId, email);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "FeedBack added to database");
//		ResponseEntity<Void> response = new ResponseEntity<FeedBack>(addFeedBack, headers, HttpStatus.CREATED);
//		return response;
//
//	}
}
