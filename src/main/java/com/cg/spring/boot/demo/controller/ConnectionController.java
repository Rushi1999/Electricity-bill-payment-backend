package com.cg.spring.boot.demo.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.service.ConnectionService;
import org.springframework.web.bind.annotation.RequestMapping;




@RestController
@RequestMapping("/connection")
@CrossOrigin(origins = "*")
public class ConnectionController {

    private static final Logger LOG = LoggerFactory.getLogger(ConnectionController.class);

    @Autowired
    private ConnectionService connectionService;
    
    
 // http://localhost:8082/registerCustomer
    @PostMapping("/addConnection")
    public ResponseEntity<Connection> addConnection(@RequestBody Connection connection) throws NoSuchConnectionException {
    	
    	 LOG.info(connection.toString());
    	 HttpHeaders headers = new HttpHeaders();
    		headers.add("message", "connection created successfully.");
//        return connectionService.newConnectionRequest(connection);
        return new ResponseEntity<Connection>(connectionService.newConnectionRequest(connection), headers, HttpStatus.CREATED);  
    }
    
    	
 // http://localhost:8082/connection/modifyConnectionAddress
    
	@PutMapping("/modifyConnectionAddress")
	public Connection updateAddress(@RequestBody Connection connection) throws NoSuchConnectionException {
		LOG.info("Controller updateConnectionAdddress");
		return connectionService.modifyConnectionAddress(connection);
	}
	
	// http://localhost:8082/modifyConnection
	@PutMapping("/modifyConnection")
	public Connection updateConnection(@RequestBody Connection connection) throws NoSuchConnectionException {
		System.out.println("Controller updateConnection");
		return connectionService. modifyConnection(connection);
	}
	
	
	
//	public List<Connection> findConnectionsByPincode(String pincode)throws NoSuchConnectionException;
	
	// http://localhost:8082/getConnectionbypincode/{pincode}
	@GetMapping("/getConnectionbypincode/{pincode}")
	public ResponseEntity<Connection> findActiveConnectionsByPincode(@PathVariable(name = "pincode")Long pincode) throws NoSuchConnectionException {
		LOG.info("getConnectionByPincode");
		List<Connection> connection = connectionService.findConnectionsByPincode(pincode); 
		LOG.info(connection.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This connections is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Connection> response = new ResponseEntity<Connection>((Connection) connection,headers,HttpStatus.OK);
		return response;
	}
	
	// http://localhost:8082/getConnectionbyId/{connectionId}
	@GetMapping("/getConnectionbyId/{connectionId}")
	public ResponseEntity<Connection>findConnectionById(@PathVariable(name = "connectionId")Long connectionId) throws NoSuchConnectionException {
		LOG.info("getConnectionById");
		Connection connection = connectionService.findConnectionById(connectionId); 
		LOG.info(connection.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This connection is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Connection> response = new ResponseEntity<Connection>(connection,headers,HttpStatus.OK);
		return response;
	}
	

}