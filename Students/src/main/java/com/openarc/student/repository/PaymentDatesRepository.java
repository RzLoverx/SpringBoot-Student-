package com.openarc.student.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openarc.student.domain.Batch;
import com.openarc.student.domain.PaymentDates;

@Repository
public interface PaymentDatesRepository extends JpaRepository<PaymentDates, Long>{
	
	List<PaymentDates> findByBatch(Batch batch, Sort sort);
	
	void deleteByBatch(Batch batch);

}
