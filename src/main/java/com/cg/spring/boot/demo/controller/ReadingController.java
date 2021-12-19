package com.cg.spring.boot.demo.controller;

import java.time.LocalDate;
import java.util.List;

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

//	@GetMapping("/getreadingbynumberandbilldate/{billDate}")
//	public ResponseEntity<Reading> getreadingbynumberandbilldate(Long consumerNumber, @PathVariable LocalDate billDate)
//			throws NoSuchCustomerException {
//		LOG.info("getreadingbynumberandbilldate");
//		Reading readingId = readingService.getreadMeterReadingByConsumerNumberAndBillDate(consumerNumber, billDate); // line
//		LOG.info(readingId.toString());
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "This consumerNumber and BillDate is available in the database.");
//		LOG.info(headers.toString());
//		ResponseEntity<Reading> readEntity = new ResponseEntity<Reading>(HttpStatus.OK);
//		return readEntity;
//	}

	// http://localhost:8082/readMeterReadingByConsumerNumber
	@GetMapping("/readmeterbynumber/{Number}")
	public ResponseEntity<Reading> readMeterReadingByConsumerNumber(@PathVariable Long consumerNumber)
			throws NoSuchCustomerException {
		LOG.info("readmeterbynumber");
		List<Reading> reading = readingService.getreadMeterReadingByConsumerNumber(consumerNumber); // line
		HttpHeaders headers = new HttpHeaders();
		LOG.info(headers.toString());
		headers.add("message", "This consumerNumber is available in the database.");
		LOG.info(headers.toString());
		ResponseEntity<Reading> response = new ResponseEntity<Reading>((Reading) reading, headers, HttpStatus.OK);
		return response;
	}
}
