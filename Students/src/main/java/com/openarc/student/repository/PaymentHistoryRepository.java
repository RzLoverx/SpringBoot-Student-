package com.openarc.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openarc.student.domain.PaymentHistory;
import com.openarc.student.domain.StudentBatchMapping;

@Repository
public interface PaymentHistoryRepository extends JpaRepository<PaymentHistory, Long>{
	
	List<PaymentHistory> findByStudentBatchMapping (StudentBatchMapping studentBatchMapping);
	
	void deleteByStudentBatchMapping(StudentBatchMapping studentBatchMapping);
	
}
