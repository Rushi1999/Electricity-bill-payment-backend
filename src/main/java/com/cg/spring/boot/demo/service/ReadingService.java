package com.cg.spring.boot.demo.service;

import java.time.LocalDate;

import java.util.List;

import com.cg.spring.boot.demo.model.Reading;

public interface ReadingService {
	public Reading SubmitReading(Reading reading);
	public Reading getreadMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate);
	public List<Reading> getreadMeterReadingByConsumerNumber(Long consumerNumber);
	
	
}
