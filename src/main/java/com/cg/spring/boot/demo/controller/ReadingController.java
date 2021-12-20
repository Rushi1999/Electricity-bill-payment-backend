package com.cg.spring.boot.demo.controller;

import java.time.LocalDate;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.model.Reading;
import com.cg.spring.boot.demo.repository.ReadingRepository;
import com.cg.spring.boot.demo.service.ReadingService;


@RestController
@RequestMapping("/reading")
@CrossOrigin(origins = "*")
public class ReadingController {
	private static final Logger LOG = LoggerFactory.getLogger(ReadingController.class);
	@Autowired
	private ReadingService readingService;
	@Autowired
	ReadingRepository repo;

	// http://localhost:8082/SubmitReading
	@PostMapping("/SubmitReading")
	public ResponseEntity<Reading> SubmitReading(@RequestBody Reading reading) throws NoSuchConnectionException {
		 LOG.info(reading.toString());
    	 HttpHeaders headers = new HttpHeaders();
    		headers.add("message", "connection created successfully.");
//        return connectionService.newConnectionRequest(connection);
        return new ResponseEntity<Reading>(readingService.SubmitReading(reading), headers, HttpStatus.CREATED);
	}
	

	// http://localhost:8082/readmeterbyReadingId/{readingId}
//	@GetMapping("/readMeterReadingByReadingId/{readingId}")
//	public ResponseEntity<Reading> readMeterReadingByReadingId(@PathVariable(name = " readingId") int readingId)
//			throws NoSuchConnectionException {
//		LOG.info("readmeterbyreadingId");
//		Reading reading = readingService.getReadingById(readingId);
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This reading is available in the database.");
//		LOG.info(headers.toString());
//		ResponseEntity<Reading> response = new ResponseEntity<Reading>(reading, headers, HttpStatus.OK);
//		return response;
//	}
	@GetMapping("/getReadingById/{readingId}")
	public ResponseEntity<Reading>getReadingById(@PathVariable(name = "readingId")int readingId) throws NoSuchConnectionException {
		LOG.info("getConnectionById");
		Reading reading = readingService.getReadingById(readingId); 
		LOG.info(reading.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This reading is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Reading> response = new ResponseEntity<Reading>(reading,headers,HttpStatus.OK);
		return response;
	}

	// http://localhost:8082/connection/getallreading
	@GetMapping("/getallreading")
	public List<Reading> getAllReading() {
		LOG.info("getAllReading"); // in normal block
		return readingService.getAllReading();
	}

	// http://localhost:8082/readMeterReadingByConsumerNumber
	@GetMapping("/readmeterbyConsumerNumber/{consumerNumber}")
	public ResponseEntity<Reading> readMeterReadingByConsumerNumber(@PathVariable Long consumerNumber)
			throws NoSuchConnectionException {
		LOG.info("readmeterbynumber");
		List<Reading> reading = readingService.getreadMeterReadingByConsumerNumber(consumerNumber); // line
		HttpHeaders headers = new HttpHeaders();
		LOG.info(headers.toString());
		headers.add("message", "This consumerNumber is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Reading> response = new ResponseEntity<Reading>( HttpStatus.OK);
		return response;
	}
}