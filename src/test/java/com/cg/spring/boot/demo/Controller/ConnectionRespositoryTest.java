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
public class ConnectionRespositoryTest {

	@Autowired
	private CustomerController connection;

	@MockBean
	private ICustomerRepository connectionRepository;

	@Test
	public void getConnectionById() {
		Customer connection = connectionRepository.findByCustomerId(1);
		connectionRepository.findByCustomerId(1);
		Optional<Customer> customerOpt = Optional.empty();
		if (customerOpt.isPresent()) {
			connection = customerOpt.get();
		}
		Assertions.assertThat(connection).isNull();
	}

}