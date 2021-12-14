package com.cg.spring.boot.demo.service;

import java.util.List;
import  com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.service.ConnectionService;

public interface ConnectionService {

	public Connection newConnectionRequest(Connection newConnection) throws NoSuchConnectionException;
	public Connection modifyConnectionAddress(Connection connection) throws NoSuchConnectionException;
	public Connection modifyConnection(Connection connection) throws NoSuchConnectionException;
	public List<Connection> findConnectionsByPincode(Long pincode) throws NoSuchConnectionException;
	public Connection getConnectionById(int connectionId) throws NoSuchConnectionException;
//	public Connection getConnectionById(int connectionId);
//	public List<Connection> getAllConnection();
	
	public List<Connection> getAllConnection();
	
	
	
}

