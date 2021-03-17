package com.openarc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openarc.student.domain.Batch;
import com.openarc.student.services.BatchService;

public class BatchController {
	
	@Autowired
	BatchService batchService;
	
	@PostMapping(value = "/batch/{couseId}")
	private Batch createBatch(@PathVariable Long courseId,@RequestBody Batch batch) {
		return batchService.creatBatch(courseId, batch);
	}
	
	@PutMapping(value = "/batch/{batchId}/{couseId}")
	private Batch updateBatch(@PathVariable Long batchId ,@PathVariable Long courseId,@RequestBody Batch batch) throws Exception {
		return batchService.updateBatch(courseId, batchId, batch);
	}
	
	@DeleteMapping(value = "/batch/{batchId}")
	private Boolean deleteBatch(@PathVariable Long batchId) {
		return batchService.deleatBatch(batchId);
	}
	
	@DeleteMapping(value = "/batch/course/{courseId}")
	private Boolean deleteByCourse(@PathVariable Long courseId) {
		return batchService.deleatByCourse(courseId);
	}

	@GetMapping(value = "/batches")
	private List<Batch> findAll(){
		return batchService.getAllBatchs();
	}
	
	@GetMapping(value = "/batch/{batchId}")
	private Batch findBatch(@PathVariable Long batchId){
		return batchService.getBatch(batchId);
	}
	
	@GetMapping(value = "/batch/course/{courseId}")
	private List<Batch> findBatchByCourse(@PathVariable Long courseId) throws Exception{
		return batchService.getAllBatchByCourseId(courseId);
	}
	
}
