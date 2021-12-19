package com.cg.spring.boot.demo.service;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.controller.PaymentController;
import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Payment;
import com.cg.spring.boot.demo.model.PaymentStatus;
import com.cg.spring.boot.demo.repository.PaymentRepository;

@Service("paymentservice")
public class PaymentServiceImpl implements PaymentService {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentRepository paymentRepo;
	
	@Override
	public PaymentStatus payBill(Long paymentId) throws NoSuchCustomerException {
		LOG.info("payBill");
		Optional<Payment> paymentOpt = paymentRepo.findById(paymentId);
		if (paymentOpt.isPresent()) {
			LOG.info(" Success");
			return ((Payment) paymentRepo).getStatus();
		} else {
			LOG.info(" Failed");
			throw new NoSuchCustomerException("Payment Failed");
		}
//		return null;
	}

//	

	@Override
	public List<Payment> viewHistoricalPayment(Long customerId) throws NoSuchCustomerException{
		List<Payment> list = paymentRepo.findByCustomer_customerId(customerId);
		if (!list.isEmpty()) {
			LOG.info("find all historical payment");
			return list;
		}
		else {
		LOG.error("No such record found");
		throw new NoSuchCustomerException("No such record found");
//		return null;
		}
		
	
	}
	
	@Override
	public void sendEmailOnPaymentCompletion(Long paymentId, String email) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public List<Payment> viewHistoricalPayment(Long paymentId) throws NoSuchCustomerException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}



//@Override
//public void sendEmailOnPaymentCompletion(Long paymentId, String email) {
//	// TODO Auto-generated method stub
//	
//}

//
//
//@Override
//public PaymentStatus payBill(Payment payment) {
//	LOG.info("payBill");
//	Optional<Payment> paymentOpt = paymentRepository.findById(payment);
//	if (paymentOpt.isPresent()) {
//		LOG.info(" Success");
//		return ((Payment) paymentRepository).getStatus();
//	} else {
//		LOG.info(" Failed");
//	}
//	return null;
//}
//
//@Override
//public void sendEmailOnPaymentCompletion(Long consumerNumber, String email) {
//	LOG.info("sendEmailOnPaymentCompletion");
//	
//	Customer paymentOpt = paymentRepository.findByConsumerNumber(consumerNumber);
//	if (paymentOpt.equals(consumerNumber)) {
//		paymentRepository.;
//		LOG.info("Employee id is deleted.");
//		return empOpt.get();
//	} else {
//		LOG.info("Employee is NOT available.");
//		throw new EmployeeNotFoundException(eid + " this employee id is not found.");
//	}
//}