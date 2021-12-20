package com.cg.spring.boot.demo.service;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Optional;

import com.cg.spring.boot.demo.exception.DuplicateCustomerException;
import com.cg.spring.boot.demo.exception.DuplicateUserException;
import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.model.Customer;
import com.cg.spring.boot.demo.model.User;
import com.cg.spring.boot.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImplemetation  implements CustomerService{
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerServiceImplemetation.class);
	
	@Autowired
	CustomerRepository customerRepository ;
	
	
	@Override
	public Customer addCustomer(Customer customer) throws DuplicateCustomerException {
		LOG.info("add");
		if (null != customerRepository.findById(customer.getCustomerId()))
			return customerRepository.save(customer);
		throw new  DuplicateCustomerException ("This customer is already registered");
	}

	@Override
	public Customer viewCustomerProfile(int CustomerId) throws NoSuchCustomerException {
		LOG.info("getCustomerById");
		Optional<Customer> empOpt = customerRepository.findById(CustomerId);
		if (empOpt.isPresent()) {
			LOG.info("Customer is available.");
			return empOpt.get();
		} else {
			LOG.info("customer is NOT available.");
			throw new NoSuchCustomerException(CustomerId + " this customer is not found.");
		}
	}

	@Override
	public Customer editCustomerProfile(int customerId) throws NoSuchCustomerException {
		return null;
	}

@Override
public Customer searchCustomerByCustomerId(Long customerId) throws NoSuchCustomerException {	
	return null;
}

@Override
public List<Customer> searchCustomerByEmail(String email) throws NoSuchCustomerException {
	LOG.info("get customer by email");
	return  ((CustomerService) customerRepository).searchCustomerByEmail(email);
}



@Override
public Customer searchCustomerByMobile(Long mobileNumber) throws NoSuchCustomerException {
	LOG.info("getCustomerByMobile");
	return customerRepository.findByMobileNumber(mobileNumber);
}

@Override
public List<Customer> searchCustomerByName(String firstName) throws NoSuchCustomerException {
	LOG.info("getCustomerByFirstName");
	return customerRepository.findByFirstName(firstName);
}

@Override
public Customer searchCustomerByAaddhar(Long aadharNumber) throws NoSuchCustomerException {
return null;
  }


@Override
public List<Customer> getAllCustomer() {
		System.out.println("Service getAllCustomer");
		return customerRepository.findAll(); 
	}
}