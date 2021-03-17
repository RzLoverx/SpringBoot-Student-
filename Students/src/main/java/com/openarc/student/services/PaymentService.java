package com.openarc.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.PaymentDates;
import com.openarc.student.domain.Student;

@Service
public class PaymentService {
	
	@Autowired
	BatchService batchService;
	
	@Autowired
	PaymentDatesService paymentDatesService;
	
	public Student paymentdeus(Long batchId) throws Exception {
		List<PaymentDates> paymentDatesList = paymentDatesService.selectPaymentDateByBatch(batchId);
		
		return null;
	}

}
