package com.cg.spring.boot.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.model.Reading;
import com.cg.spring.boot.demo.repository.ReadingRepository;
@Service
public class ReadingServiceImpl implements ReadingService {
	@Autowired
	private ReadingRepository dao;
	@Override
	public Reading SubmitReading(Reading reading) {
		// TODO Auto-generated method stub
//		return (Reading) dao.selfSubmitReading(reading);
		return null;
	}

	@Override
	public Reading getreadMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate) {
		// TODO Auto-generated method stub
//		return dao.readMeterReadingByConsumerNumberAndBillDate(consumerNumber, billDate);
		return null;
	}

	@Override
	public List<Reading> getreadMeterReadingByConsumerNumber(Long consumerNumber) {
		// TODO Auto-generated method stub
//		return dao.readMeterReadingByConsumerNumber(consumerNumber);
		return null;
	}
	

}
