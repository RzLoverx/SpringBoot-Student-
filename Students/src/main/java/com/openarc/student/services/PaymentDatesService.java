package com.openarc.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.Batch;
import com.openarc.student.domain.PaymentDates;
import com.openarc.student.repository.BatchRepository;
import com.openarc.student.repository.PaymentDatesRepository;

@Service
public class PaymentDatesService {
	
	@Autowired
	PaymentDatesRepository paymentDatesRepository;
	
	@Autowired
	BatchRepository batchRepository;
	
	public PaymentDates CreatPaymentDates(PaymentDates paymentDates,Long batchId) {
		Batch batch= batchRepository.findById(batchId).get();
		paymentDates.setBatch(batch);
		return paymentDatesRepository.save(paymentDates);
	}
	
	public PaymentDates UpadatePaymentDates(PaymentDates paymentDates,Long paymentDateId,Long batchId) throws Exception {
		if(!batchRepository.existsById(batchId)) {
			throw new Exception("BatchId " + batchId + " not found");
		}
		else {
			paymentDates.setBatch(batchRepository.findById(batchId).get());
			paymentDates.setPaymentDateId(paymentDateId);
			return paymentDatesRepository.save(paymentDates);
		}
	}
	
	public List<PaymentDates> selectPaymentDateByBatch(Long batchId) throws Exception{
		if(!batchRepository.existsById(batchId)) {
			throw new Exception("BatchId " + batchId + " not found");
		}
		else {
			Batch batch= batchRepository.findById(batchId).get();
			return paymentDatesRepository.findByBatch(batch, Sort.by(Sort.Direction.ASC));
		}
	}
	
	public List<PaymentDates> selectAllPaymentDates(){
		return paymentDatesRepository.findAll();
	}
	
	public PaymentDates selectPaymentDate(Long paymentDateId) {
		return paymentDatesRepository.findById(paymentDateId).get();
	}
	
	public Boolean deleatPaymentDate(Long paymentDateId) {
		try {
			paymentDatesRepository.deleteById(paymentDateId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean deleatPaymentDateByBatch(Long batchId) {
		try {
			Batch batch = batchRepository.findById(batchId).get();
			paymentDatesRepository.deleteByBatch(batch);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
