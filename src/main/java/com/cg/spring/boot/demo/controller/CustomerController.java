package com.cg.spring.boot.demo.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.exception.DuplicateCustomerException;
import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Customer;
import com.cg.spring.boot.demo.service.CustomerService;



@RestController
public class CustomerController {

	private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);


	@Autowired
	private CustomerService customerService;
	//@Autowired
	//private AddressRespository  addressRespository ;

	// http://localhost:8082/registerCustomer
	@PostMapping("/registerCustomer")
	public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws DuplicateCustomerException {
		LOG.info("Controller register");
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "User registered successfully.");
		return new ResponseEntity<Customer>(customerService.registerCustomer(customer), headers, HttpStatus.CREATED);
	}


	@GetMapping("/getcustomerbyid/{customerId}")
	public ResponseEntity<Customer> getEmpById(@PathVariable(name = "customerId") int customerId) throws NoSuchCustomerException {
		LOG.info("getCustomerById");
		Customer customername = customerService.viewCustomerProfile(customerId); // line
		LOG.info(customername.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This customer is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(customername, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getbyname/{email}")
	public List<Customer> getCustomerEmail(@PathVariable String email) throws NoSuchCustomerException {
		LOG.info("getByemail");
		return customerService.searchCustomerByEmail(email);
	}

	@GetMapping("/getcustomerbyAddhar/{aadharNumber}")
	public ResponseEntity<Customer> getAddharNumber(@PathVariable(name = "aadharNumber") Long aadharNumber) throws NoSuchCustomerException {
		LOG.info("getCustomerByAddhar");
		Customer customername = customerService.searchCustomerByAaddhar(aadharNumber); // line
		LOG.info(customername.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This customer is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(customername, headers, HttpStatus.OK);
		return response;
	}

	@GetMapping("/getbyname/{firstName}")
	public List<Customer> getCustomerByFirstName(@PathVariable String firstName) throws NoSuchCustomerException {
		LOG.info("getEmpByFirstName");
		return customerService.searchCustomerByName(firstName);
	}
	@GetMapping("/getbymobile/{mobileNumber}")
	public List<Customer> getCustomerByMobile(@PathVariable Long mobileNumber) throws NoSuchCustomerException {
		LOG.info("getEmpByMobileNumber");
		HttpHeaders headers = new HttpHeaders();
		ResponseEntity<Customer> response = new ResponseEntity<Customer>(headers, HttpStatus.OK);
		return (List<Customer>) customerService.searchCustomerByMobile(mobileNumber);
		
	}
}