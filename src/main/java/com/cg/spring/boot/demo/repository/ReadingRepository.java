package com.cg.spring.boot.demo.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.spring.boot.demo.model.Reading;
@Repository
public interface ReadingRepository extends JpaRepository<Reading, Long> {
//	
//	@Query("select r from ReadingDao r inner join r.connection con where con.reading = ?1")
//	public ReadingDao readBillByConsumerNumber(Long consumerNumber);
//	
//	@Query("select r from ReadingDao r inner join r.connection con where con.consumerNumber = ?1")
//	public ReadingDao readBillByMobileNumber(String mobileNumber);
//	
//	@Query("select r from ReadingDao r inner join r.connection con where con.billDate= ?1")
//	public ReadingDao readBillByEmail(String email);
//	
//	@Query(name = "SELECT r FROM ReadingDao WHERE r.date BETWEEN ?1 AND ?2")
//	public static List<ReadingDao> readBillForDateRange(LocalDate from, LocalDate to) {
//		return readBillForDateRange(from, to);
//	

	
	
	@Query(value = "SELECT r FROM Reading r WHERE r.reading = ?1")
	public Reading submitReading(Long reading);
	

	@Query(value = "SELECT r FROM Reading r WHERE r.connection.consumerNumber= ?1 AND r.bill.billDate= ?2")
	public Reading readMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, LocalDate billDate);
	
	@Query(value = "SELECT r FROM Reading r WHERE r.connection.consumerNumber = ?1")
	public List<Reading> readMeterReadingByConsumerNumber(Long consumerNumber);
}

