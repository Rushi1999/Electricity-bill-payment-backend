package com.cg.spring.boot.demo.service;

import java.util.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cg.spring.boot.demo.exception.DuplicateUserException;
import com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.exception.NoSuchCustomerException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.repository.ConnectionRespository;
import com.cg.spring.boot.demo.repository.CustomerRepository;

//import logging.GlobalResources;

@Service
class ConnectionServiceImpliment implements ConnectionService {
//	private static final Logger LOG = LoggerFactory.getLogger(ConnectionServiceImpliment.class);
	private Logger Logger = LoggerFactory.getLogger(ConnectionServiceImpliment.class);

	@Autowired
	private ConnectionRespository connectionRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public Connection newConnectionRequest(Connection connection) throws NoSuchConnectionException {
//		if (customerRepository.existsById(connection.getCustomer().getCustomerId()))
			return connectionRepository.save(connection);
	//	throw new NoSuchConnectionException(
				//"customer with customerId " + connection.getCustomer().getCustomerId() + " does not exist.");
	}
	
//	  if (!connectionRepository.existsById(connection.getConnectionId())) {

//			if (connection.getCustomer() != null )
//				return connectionRepository.save(connection);
//			else if (connectionRepository.existsById(connection.getCustomer().getCustomerId()) )
//				return connectionRepository.save(connection);
//			else
//				throw new NoSuchConnectionException("customer with customerId " + connection.getCustomer().getCustomerId() + " does not exist.");
//		
//	  }
//  else
//			throw new NoSuchConnectionException("connection with connectionId " + connection.getConnectionId() + " already exists.");
//	  	  
//	}

	@Override
	public List<Connection> getAllConnection() {
		System.out.println("Service getAllConnections");
		return connectionRepository.findAll();
	}

	@Override
	public Connection modifyConnection(Connection connection) throws NoSuchConnectionException {

		Logger.info("Service Modify Connection");
		if (connectionRepository.existsById(connection.getConnectionId())) {
			return connectionRepository.save(connection);
		} else {
			Logger.error("Connection does not exist.");
			throw new NoSuchConnectionException(connection.getConnectionId() + "does not exits");
		}
	}

//	@Override

//	public Connection modifyConnectionAddress(Connection connection) throws NoSuchConnectionException {
//		
//			if (connectionRepository.existsById(connection.getConnectionId()))
//			{
//				Logger.info("Service update Connection Address");
//				return connectionRepository.save(connection);	
//			}
//			else
//			{
//				Logger.error("Connection Not Found");
//				throw new NoSuchConnectionException("Connection not found");
//
//			}				
//		
//	}

	@Override
	public List<Connection> getConnectionsByPincode(int pincode) throws NoSuchConnectionException {
		Logger.info("getConnectionIdByPincode");
		Optional<Connection> connection = connectionRepository.findById(pincode);
		if (connection.isPresent()) {
			Logger.info("Connection is available.");
			return (List<Connection>) connection.get();
		} else {
			Logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(pincode + " this connection is not found.");
		}

	}

	@Override
	public Connection getConnectionById(int connectionId) throws NoSuchConnectionException {
		Logger.info("getConnectionIdById");
		Optional<Connection> connection = connectionRepository.findById(connectionId);
		if (connection.isPresent()) {
			Logger.info("Connection is available.");
			return connection.get();
		} else {
			Logger.error("connection is NOT available.");
			throw new NoSuchConnectionException(connectionId + " this connection is not found.");
		}

	}

//	@Override
//	public Connection getConnectionByCustomerId(int customerId) throws NoSuchConnectionException {
//		Logger.info("getConnectionIdById");
//			Optional<Connection> connection = connectionRepository.findById(customerId);
//			if (connection.isPresent()) {
//				Logger.info("Connection is available.");
//				return connection.get();
//			} else {
//				Logger.error("connection is NOT available.");
//				throw new  NoSuchConnectionException(customerId + " this connection is not found.");
//			}		
//
//	}	

}