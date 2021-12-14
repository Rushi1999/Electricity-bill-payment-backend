package com.cg.spring.boot.demo.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.boot.demo.exception.NoSuchCustomerException;
import com.cg.spring.boot.demo.model.Reading;
import com.cg.spring.boot.demo.repository.ReadingRepository;
import com.cg.spring.boot.demo.service.ReadingService;

@RestController
public class ReadingController {
	private static final Logger LOG = LoggerFactory.getLogger(ReadingController.class);
	@Autowired
	private ReadingService readingService;
	@Autowired
	ReadingRepository repo;

	// http://localhost:8082/selfSubmitReading
	@GetMapping("/reading")
	public ResponseEntity<Reading> SubmitReading(@PathVariable Reading reading) throws NoSuchCustomerException {
		LOG.info("SubmitReading");
		Reading readingId = readingService.SubmitReading(reading); // line
		LOG.info(readingId.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This reading is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Reading> readEntity = new ResponseEntity<Reading>(HttpStatus.OK);
		return readEntity;
	}

	@GetMapping("/getreadingbynumberandbilldate/{billDate}")
	public ResponseEntity<Reading> getreadingbynumberandbilldate(Long consumerNumber, @PathVariable LocalDate billDate)
			throws NoSuchCustomerException {
		LOG.info("getreadingbynumberandbilldate");
		Reading readingId = new Reading(null, null, 0, null, null, 0); // line
		LOG.info(readingId.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This consumerNumber and BillDate is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Reading> readEntity = new ResponseEntity<Reading>(HttpStatus.OK);
		return readEntity;
	}

	// http://localhost:8082/readMeterReadingByConsumerNumber
	@GetMapping("/readmeterbynumber/{Number}")
	public ResponseEntity<Reading> readMeterReadingByConsumerNumber(Long consumerNumber, @PathVariable Long Number)
			throws NoSuchCustomerException {
		LOG.info("readmeterbynumber");
		Reading consumerNumber1 = new Reading(null, null, 0, null, null, 0); // line
		LOG.info(consumerNumber1.toString());
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This consumerNumber is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Reading> response = new ResponseEntity<Reading>(consumerNumber1, headers, HttpStatus.OK);
		return response;
	}
}
