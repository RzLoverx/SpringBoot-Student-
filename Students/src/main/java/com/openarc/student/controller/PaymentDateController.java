package com.openarc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openarc.student.domain.PaymentDates;
import com.openarc.student.services.PaymentDatesService;

public class PaymentDateController {

	@Autowired
	PaymentDatesService paymentDatesService;
	
	@PostMapping(value = "/paymentDate/{batchId}")
	private PaymentDates createPaymentDates(@PathVariable Long batchId,@RequestBody PaymentDates paymentDates) {
		return paymentDatesService.CreatPaymentDates(paymentDates, batchId);
	}
	
	@PutMapping(value = "/paymentDate/{paymentDateId}/{batchId}")
	private PaymentDates updatePaymentDates(@PathVariable Long batchId,@PathVariable long paymentDateId,@RequestBody PaymentDates paymentDates) throws Exception {
		return paymentDatesService.UpadatePaymentDates(paymentDates, paymentDateId, batchId);
	}
	
	@DeleteMapping (value = "/paymentDate/{paymentDateId}")
	private Boolean deletPaymentDates(@PathVariable Long paymentDateId) {
		return paymentDatesService.deleatPaymentDate(paymentDateId);
	}
	
	@DeleteMapping(value = "/paymentDate/batch/{batchId}")
	private Boolean deletPaymentDateByBatch(@PathVariable Long batchId) {
		return paymentDatesService.deleatPaymentDateByBatch(batchId);
	}
	
	@GetMapping(value = "/paymentDates")
	private List<PaymentDates> selectAll(){
		return paymentDatesService.selectAllPaymentDates();
	}
	
	@GetMapping(value = "/paymentDate/{paymentDateId}")
	private PaymentDates selectPaymentDate(@PathVariable Long paymentDateId) {
		return paymentDatesService.selectPaymentDate(paymentDateId);
	}
	
	@GetMapping(value = "/paymentDate/batch/{batchId}")
	private List<PaymentDates> selectByBatch(@PathVariable Long batchId) throws Exception{
		return paymentDatesService.selectPaymentDateByBatch(batchId);
	}
}
