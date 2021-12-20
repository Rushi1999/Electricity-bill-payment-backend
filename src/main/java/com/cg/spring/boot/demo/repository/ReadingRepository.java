package com.cg.spring.boot.demo.repository;

	import java.time.LocalDate;
	import java.util.List;
	import java.util.Optional;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.stereotype.Repository;

	import com.cg.spring.boot.demo.model.Customer;
	import com.cg.spring.boot.demo.model.Reading;
	@Repository
	public interface ReadingRepository extends JpaRepository<Reading, Integer> {

//		public Optional<Reading> findByConsumerNumber(Long consumerNumber);
		public abstract List<Reading> findByConnection_consumerNumber(Long consumerNumber);
	

}