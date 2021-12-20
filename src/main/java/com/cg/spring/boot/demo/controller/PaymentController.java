package com.cg.spring.boot.demo.controller;

import java.util.List;

import javax.transaction.InvalidTransactionException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Payment;
import com.cg.spring.boot.demo.model.PaymentStatus;
import com.cg.spring.boot.demo.service.PaymentServiceImpl;


@Component
@RestController
@RequestMapping("/payment")
@CrossOrigin(origins = "*")
public class PaymentController {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentServiceImpl paymentService;
	
	@GetMapping("/getpaymentbyId/{paymentId}")
	public ResponseEntity<Payment>getPaymentById(@PathVariable(name = "paymentId")long paymentId) throws NoSuchCustomerException {
		LOG.info("getConnectionById");
		Payment pay = paymentService.getPaymentById(paymentId); 
		LOG.info(pay.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This Paymentid is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Payment> response = new ResponseEntity<Payment>(pay,headers,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/registerbill")
	public ResponseEntity<PaymentStatus>  RegisterBill(@Valid @RequestBody Payment payment) throws InvalidTransactionException{
		LOG.info("dealerPayToCompany controller");
		PaymentStatus pay = paymentService.payBill(payment);
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This payBill is success.");
		LOG.info(headers.toString());
		ResponseEntity<PaymentStatus> response = new ResponseEntity<PaymentStatus>(pay, headers, HttpStatus.OK);
		return response;
	}
	
	
	 @GetMapping("/getallpayment")
		public List<Payment> getAllPayment() {
			LOG.info("getAllPayement"); 
			return paymentService.getAllPayments();
		}
	 
	 
	@GetMapping("/readhistoricalpayment/{customerId}")
	public ResponseEntity<List<Payment>> getListByFarmerId(@PathVariable(name="customerId")long customerId) throws NoSuchCustomerException	{
			LOG.info("readHistoricalPayment");
			ResponseEntity<List<Payment>> response = null;
			List<Payment> list = paymentService.viewHistoricalPayment(customerId);
			HttpHeaders headers = new HttpHeaders();
			headers.add("message", "FeedBack added to database");
			response = new ResponseEntity<List<Payment>>(list, HttpStatus.CREATED);
			return response;
	}

}