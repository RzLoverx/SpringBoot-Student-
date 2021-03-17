package com.openarc.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.PaymentHistory;
import com.openarc.student.repository.PaymentHistoryRepository;
import com.openarc.student.repository.StudentBatchMappingRepository;

@Service
public class PaymentHistoryService {

	@Autowired
	PaymentHistoryRepository paymentHistoryRepository;
	
	@Autowired
	StudentBatchMappingRepository studentBatchMappingRepository;
	
	public PaymentHistory createPaymentHistory(PaymentHistory paymentHistory, Long studentBatchMappingId ) throws Exception {
		if(!studentBatchMappingRepository.existsById(studentBatchMappingId)) {
			throw new Exception("StudentBatchMapingId " + studentBatchMappingId + " not found");
		}
		else
		{
			paymentHistory.setStudentBatchMapping(studentBatchMappingRepository.findById(studentBatchMappingId).get());
			return paymentHistoryRepository.save(paymentHistory);
		}
	}
	
	public PaymentHistory updatePaymentHistory(PaymentHistory paymentHistory, Long paymentHistoryId, Long studentBatchMappingId) throws Exception {
		if(!studentBatchMappingRepository.existsById(studentBatchMappingId)) {
			throw new Exception("StudentBatchMapingId " + studentBatchMappingId + " not found");
		}
		else {
			paymentHistory.setStudentBatchMapping(studentBatchMappingRepository.findById(studentBatchMappingId).get());
			paymentHistory.setPaymentHistoryId(paymentHistoryId);
			return paymentHistoryRepository.save(paymentHistory);
		}
	}
	
	public Boolean deletePaymentHistory(Long paymentHistoryId) {
		try {
			paymentHistoryRepository.deleteById(paymentHistoryId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean deletePaymentHistoryByStudentBatchMapping(Long studentBatchMappingId) {
		try {
			paymentHistoryRepository.deleteByStudentBatchMapping(studentBatchMappingRepository.findById(studentBatchMappingId).get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public PaymentHistory selectPaymentHistoryById(Long paymentHistoryId) {
		return paymentHistoryRepository.findById(paymentHistoryId).get();
	}
	
	public List<PaymentHistory> selectPaymentHistories(){
		return paymentHistoryRepository.findAll();
	}
	
	public List<PaymentHistory> selectPaymentHistoryByStudentBatchMappingId(Long studentBatchMappingId) throws Exception{
		if(!studentBatchMappingRepository.existsById(studentBatchMappingId)) {
			throw new Exception("StudentBatchMapingId " + studentBatchMappingId + " not found");
		}
		else {
			return paymentHistoryRepository.findByStudentBatchMapping(studentBatchMappingRepository.findById(studentBatchMappingId).get());
		}
	}
}
