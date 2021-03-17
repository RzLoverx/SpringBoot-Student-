package com.openarc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openarc.student.domain.StudentBatchMapping;
import com.openarc.student.services.StudentBatchMappingService;

public class StudentBatchMappingController {
	
	@Autowired
	StudentBatchMappingService studentBatchMappingService;
	
	@PostMapping(value = "/studentBatchMapping/{studentId}/{batchId}")
	private StudentBatchMapping creatStudentBatchMapping(@RequestBody StudentBatchMapping studentBatchMapping,@PathVariable Long studentId,@PathVariable Long batchId) throws Exception {
		return studentBatchMappingService.creatrStudentBatchMapping(studentBatchMapping, studentId, batchId);
	}
	
	@PutMapping(value = "/studentBatchMapping/{studentId}/{batchId}/{studentBatchMappingId}")
	private StudentBatchMapping updateStudentBatchMapping(@RequestBody StudentBatchMapping studentBatchMapping,@PathVariable Long studentId,@PathVariable Long batchId,@PathVariable Long studentBatchMappingId) throws Exception {
		return studentBatchMappingService.updateStudentBatchMapping(studentBatchMapping, studentBatchMappingId, studentId, batchId);
	}

	@DeleteMapping(value = "/studentBatchMapping/{studentBatchMappingId}")
	private Boolean deletStudentBatchMapping(@PathVariable Long studentBatchMappingId) {
		return studentBatchMappingService.deleteStudentBatchMapping(studentBatchMappingId);
	}
	
	@DeleteMapping(value = "/studentBatchMapping/{studentBatchMappingId}")
	private Boolean deletStudentBatchMappingByStudent(@PathVariable Long studentId) {
		return studentBatchMappingService.deleteByStudent(studentId);
	}
	
	@DeleteMapping(value = "/studentBatchMapping/student/{studentId}")
	private Boolean deletStudentBatchMappingByBatch(@PathVariable Long batchId) {
		return studentBatchMappingService.deleteByBatch(batchId);
	}
	
	@GetMapping(value = "/studentBatchMapping/batch/{batchId}")
	private StudentBatchMapping getStudentBatchMapping(@PathVariable Long studentBatchMappingId) {
		return studentBatchMappingService.findBystudentBatchMappingId(studentBatchMappingId);
	}
	
	@GetMapping(value = "/studentBatchMappings")
	private List<StudentBatchMapping> getAllStudentBatchMappings(){
		return studentBatchMappingService.findAll();
	}
	
	@GetMapping(value = "/studentBatchMapping/student/{studentId}")
	private List<StudentBatchMapping> getStudentBatchMappingByStudent(@PathVariable Long studentId) throws Exception {
		return studentBatchMappingService.findAllByStudent(studentId);
	}
	
	@GetMapping(value = "/studentBatchMapping/batch/{batchId}")
	private List<StudentBatchMapping> getStudentBatchMappingByBatch(@PathVariable Long batchId) throws Exception {
		return studentBatchMappingService.findAllByBatch(batchId);
	}

}
