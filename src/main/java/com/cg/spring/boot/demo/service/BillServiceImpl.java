package com.cg.spring.boot.demo.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.boot.demo.exception.NoSuchConnectionException;
import com.cg.spring.boot.demo.exception.NoSuchConsumerNumberException;
import com.cg.spring.boot.demo.exception.NoSuchDateRangeException;
import com.cg.spring.boot.demo.exception.NoSuchEmailException;
import com.cg.spring.boot.demo.exception.NoSuchMobileNumberException;
import com.cg.spring.boot.demo.model.Bill;
import com.cg.spring.boot.demo.model.Connection;
import com.cg.spring.boot.demo.model.Reading;
import com.cg.spring.boot.demo.repository.BillRepository;

@Service("bill_service")
public class BillServiceImpl implements BillService {

	private static final Logger LOG = LoggerFactory.getLogger(BillServiceImpl.class);

	@Autowired
	private BillRepository billDao;

	
	@Override
	public List<Bill> viewBillByConsumerNumber(Long consumerNumber) throws NoSuchConnectionException {
		LOG.info("viewBillByConsumerNumber");
		List<Bill> billopt = billDao.readBillByConsumerNumber(consumerNumber);
		LOG.info("data fetched for viewBillByConsumerNumber");
		if (billopt != null) {
			LOG.info("Bill is available");
			return billopt;
		} else {
			LOG.info("Bill is not available");
			throw new  NoSuchConnectionException(consumerNumber + " This bill is not found");
		}
	}
	
	
//	@Override
//	public List<Reading> getreadMeterReadingByConsumerNumber(Long consumerNumber) throws NoSuchConnectionException {
//		// TODO Auto-generated method stub
//		LOG.info("getreadMeterReadingByConsumerNumber");
//		if(connectionRepository.findByConsumerNumber(consumerNumber)!=null)
//		return readingRepository.findByConnection_consumerNumber(consumerNumber);
//			throw new NoSuchConnectionException(consumerNumber + " this consumerNumber is not found.");
//		}
			
	@Override
	public List<Bill> getAllBill() {
		System.out.println("Service getAllBills");
		return billDao.findAll();
	}

	@Override
	public Bill getBillById(Long billId) throws NoSuchConnectionException {
		LOG.info("getConnectionIdById");
		Optional<Bill> bill = billDao.findById(billId);
		if (bill.isPresent()) {
			LOG.info("Connection is available.");
			return bill.get();
		} else {
			LOG.error("connection is NOT available.");
			throw new NoSuchConnectionException(billId + " this connection is not found.");
		}

	}
	
	@Override
	public Bill viewBillByMobileNumber(Long mobileNumber) throws NoSuchMobileNumberException {
		LOG.info("viewBillByMobileNumber");
		Bill billopt = billDao.readBillByMobileNumber(mobileNumber);
		if (billopt != null) {
			LOG.info("Bill is available");
			return billopt;
		} else {
			LOG.info("Bill is not available");
			throw new NoSuchMobileNumberException(mobileNumber + " This bill is not found");
		}

	}

	@Override
	public Bill viewBillByEmail(String email) throws NoSuchEmailException {
		LOG.info("viewBillByEmail");
		Bill billopt = billDao.readBillByEmail(email);
		if (billopt != null) {
			LOG.info("Bill is available");
			return billopt;
		} else {
			LOG.info("Bill is not available");
			throw new NoSuchEmailException(email + " This bill is not found");
		}
	}

	@Override
	public List<Bill> viewBillForDateRange(LocalDate from, LocalDate to) throws NoSuchDateRangeException {
		LOG.info("viewBillForDateRange");
		List<Bill> billopt = billDao.readBillForDateRange(from, to);
		if (!billopt.isEmpty()) {
			LOG.info("Bill is available.");
			return billopt;
		} else {
			LOG.info("Bill is NOT available.");
			throw new NoSuchDateRangeException(from + " " + to + " This bill is not found");
		}
	}

}
