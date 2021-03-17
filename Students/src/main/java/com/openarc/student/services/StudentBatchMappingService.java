package com.openarc.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.StudentBatchMapping;
import com.openarc.student.repository.BatchRepository;
import com.openarc.student.repository.StudentBatchMappingRepository;
import com.openarc.student.repository.StudentRepository;

@Service
public class StudentBatchMappingService {
	
	@Autowired
	StudentBatchMappingRepository studentBatchMappingRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	BatchRepository batchRepository;

	public StudentBatchMapping creatrStudentBatchMapping(StudentBatchMapping studentBatchMapping ,Long studentId, Long batchId) throws Exception{
		if(!studentRepository.existsById(studentId)) {
			throw new Exception("StudentId " + studentId + " not found");
		}
		else if(! batchRepository.existsById(batchId)) {
			throw new Exception("BatchId " + batchId + " not found");
		}
		else {
			studentBatchMapping.setStudent(studentRepository.findById(studentId).get());
			studentBatchMapping.setBatch(batchRepository.findById(batchId).get());
			return studentBatchMappingRepository.save(studentBatchMapping);
		}
		
	}
	
	public StudentBatchMapping updateStudentBatchMapping(StudentBatchMapping studentBatchMapping ,Long studentBatchMappingId, Long studentId, Long batchId) throws Exception {
		if(!studentRepository.existsById(studentId)) {
			throw new Exception("StudentId " + studentId + " not found");
		}
		else if(! batchRepository.existsById(batchId)) {
			throw new Exception("BatchId " + batchId + " not found");
		}
		else {
			studentBatchMapping.setStudentBatchMappingId(studentBatchMappingId);
			studentBatchMapping.setStudent(studentRepository.findById(studentId).get());
			studentBatchMapping.setBatch(batchRepository.findById(batchId).get());
			return studentBatchMappingRepository.save(studentBatchMapping);
		}
	}
	
	public Boolean deleteStudentBatchMapping(Long studentBatchMappingId) {
		try {
			studentBatchMappingRepository.deleteById(studentBatchMappingId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean deleteByStudent(Long studentId) {
		try {
			studentBatchMappingRepository.deleteByStudent(studentRepository.findById(studentId).get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean deleteByBatch(Long batchId) {
		try {
			studentBatchMappingRepository.deleteByBatch(batchRepository.findById(batchId).get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public List<StudentBatchMapping> findAll(){
		return studentBatchMappingRepository.findAll();
	}
	
	public StudentBatchMapping findBystudentBatchMappingId(Long studentBatchMappingId) {
		return studentBatchMappingRepository.findById(studentBatchMappingId).get();
	}

	public List<StudentBatchMapping> findAllByStudent(Long studentId) throws Exception{
		if(!studentRepository.existsById(studentId)) {
			throw new Exception("StudentId " + studentId + " not found"); 
		}
		else {
			return studentBatchMappingRepository.findByStudent(studentRepository.findById(studentId).get());
		}
	}
	
	public List<StudentBatchMapping> findAllByBatch(Long batchId) throws Exception{
		if(!batchRepository.existsById(batchId)) {
			throw new Exception("BatchId " + batchId + " not found"); 
		}
		else {
			return studentBatchMappingRepository.findByBatch(batchRepository.findById(batchId).get());
		}
	}
}
