package com.cg.spring.boot.demo.service;

import java.time.LocalDate;

import java.util.List;

import com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.model.Reading;

public interface ReadingService {
	public abstract List<Reading> findByConnection_consumerNumber(Long consumerNumber);
	public Reading SubmitReading(Reading reading) throws NoSuchConnectionException;


//    public List<Reading> getReadingById(int readingId) throws NoSuchConnectionException;
	public List<Reading> getAllReading();
	public abstract List<Reading> getreadMeterReadingByConsumerNumber(Long consumerNumber) throws NoSuchConnectionException;
	public Reading getReadingById(int readingId) throws NoSuchConnectionException;
	

	
	
}