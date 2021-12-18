package com.cg.spring.boot.demo.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import  com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.service.ConnectionService;

public interface ConnectionService {

	public Connection newConnectionRequest(Connection newConnection) throws NoSuchConnectionException;
	//public Connection modifyConnectionAddress(Connection connection) throws NoSuchConnectionException;
	public Connection modifyConnection(Connection connection) throws NoSuchConnectionException;
	public Connection getConnectionById(int connectionId) throws NoSuchConnectionException;
//	public Connection getConnectionById(int connectionId);
	public List<Connection> getAllConnection();

//	@Query(value = "SELECT c FROM Reading c WHERE c.connection.pincode = ?1")
	//public List<Connection> getConnectionsByPincode(Long pincode) throws NoSuchConnectionException;
	List<Connection> getConnectionsByPincode(int pincode) throws NoSuchConnectionException;
	
	
	
	
}

