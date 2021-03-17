package com.openarc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openarc.student.domain.PaymentHistory;
import com.openarc.student.services.PaymentHistoryService;

public class PaymentHistoryController {
	
	@Autowired
	PaymentHistoryService paymentHistoryService;
	
	@PostMapping(value = "/paymentHistory/{studentBatchMappingId}")
	private PaymentHistory createPaymentHistory(@PathVariable Long studentBatchMappingId ,@RequestBody PaymentHistory paymentHistory) throws Exception {
		return paymentHistoryService.createPaymentHistory(paymentHistory, studentBatchMappingId);
	}

	@PutMapping(value = "/paymetHistory/{studentBatchMappingId}/{paymetHistoryId}")
	private PaymentHistory updatePaymentHistory(@PathVariable Long studentBatchMappingId ,@PathVariable Long paymentHistoryId,@RequestBody PaymentHistory paymentHistory) throws Exception {
		return paymentHistoryService.updatePaymentHistory(paymentHistory, paymentHistoryId, studentBatchMappingId);
	}
	
	@DeleteMapping(value = "/paymentHistory/{paymentHistoryId}")
	private Boolean deletePymanetHistory(@PathVariable Long paymentHistoryId) {
		return paymentHistoryService.deletePaymentHistory(paymentHistoryId);
	}
	
	@DeleteMapping(value = "/paymetHistory/studeentBatchMapping/{studentBatchMappingId}")
	private Boolean deleteByStudentBatchMapping(@PathVariable Long studentBatchMappingId) {
		return paymentHistoryService.deletePaymentHistoryByStudentBatchMapping(studentBatchMappingId);
	}
	
	@GetMapping(value = "paymentHistories")
	private List<PaymentHistory> selectAll(){
		return paymentHistoryService.selectPaymentHistories();
	}
	
	@GetMapping(value = "/paymentHistory/{paymentHistoryId}")
	private PaymentHistory select(@PathVariable Long paymentHistoryId) {
		return paymentHistoryService.selectPaymentHistoryById(paymentHistoryId);
	}
	
	@GetMapping(value = "/paymetHistory/studentBatchMapping/{studentBatchMappingId}")
	private List<PaymentHistory> selectByStudeentBatchMapping(@PathVariable Long studentBatchMappingId) throws Exception{
		return paymentHistoryService.selectPaymentHistoryByStudentBatchMappingId(studentBatchMappingId);
	}
}
