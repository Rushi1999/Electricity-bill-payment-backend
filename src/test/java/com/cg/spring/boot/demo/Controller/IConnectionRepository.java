package com.cg.spring.boot.demo.Controller;

import java.util.List;

import com.cg.spring.boot.demo.exception.DuplicateUserException;
import com.cg.spring.boot.demo.exception.InvalidLoginCredentialException;
import com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.exception.NoSuchUserException;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.model.Customer;
import com.cg.spring.boot.demo.model.User;
public interface IConnectionRepository {
	


	public interface IConnectionService {
		
		public Connection newConnectionRequest(Connection newConnection) throws NoSuchConnectionException;
		public Connection modifyConnectionAddress(Connection connection);
		public Connection modifyConnection(Connection connection) throws NoSuchConnectionException;
		public List<Connection> findConnectionsByPincode(Long pincode) throws NoSuchConnectionException;
		public Connection findConnectionById(Long connectionId) throws NoSuchConnectionException;
		


	}

	public Connection findConnectionById(int i);

}



