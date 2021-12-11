package com.cg.spring.boot.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import  com.cg.spring.boot.demo.model.Connection;

@Repository
public interface ConnectionRespository extends JpaRepository<Connection, Long> {

	

	
//	public Connection createConnection(Connection newConnection);
//	public Customer readCustomerByConsumerNumber(Long consumerNumber);
//	public Connection updateConnectionAddress(Connection connection);
//	public Connection updateConnection(Connection connection);
	
	public Connection findByConnectionId(int connectionId);

	

}