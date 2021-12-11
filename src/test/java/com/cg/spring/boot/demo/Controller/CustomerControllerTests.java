package com.cg.spring.boot.demo.Controller;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.spring.boot.demo.controller.CustomerController;
import com.cg.spring.boot.demo.model.Customer;


@SpringBootTest
public class CustomerControllerTests {

	@Autowired
	private CustomerController controller;

	@MockBean
	private ICustomerRepository CustomerRepository;

	@Test
	public void getCustomerById() {
		Customer customer = CustomerRepository.findByCustomerId(1);
		CustomerRepository.findByCustomerId(1);
		Optional<Customer> customerOpt = Optional.empty();
		if (customerOpt.isPresent()) {
			customer = customerOpt.get();
		}
		Assertions.assertThat(customer).isNull();
	}

}