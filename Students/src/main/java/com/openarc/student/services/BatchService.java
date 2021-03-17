package com.openarc.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.Batch;
import com.openarc.student.domain.Course;
import com.openarc.student.repository.BatchRepository;
import com.openarc.student.repository.CourseRepository;

@Service
public class BatchService {
	
	@Autowired
	BatchRepository batchRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	public List<Batch> getAllBatchByCourseId(Long courseId) throws Exception{
		if(!courseRepository.existsById(courseId)) {
			throw new Exception("CourseId " + courseId + " not found");
		}
		else {
			Course course= courseRepository.findById(courseId).get();
			return batchRepository.findByCourse(course, Sort.by(Sort.Direction.ASC));
		}
	}
	
	public List<Batch> getAllBatchs(){
		return batchRepository.findAll();
	}
	
	public Batch getBatch(Long batchId) {
		return batchRepository.findById(batchId).get();
	}
	
	public Batch creatBatch(Long courseId ,Batch batch) {
		batch.setCourse(courseRepository.findById(courseId).get());
		return batchRepository.save(batch);
	}
	
	public Batch updateBatch(Long courseId, Long batchId , Batch batch) throws Exception {
		if(!courseRepository.existsById(courseId)) {
			throw new Exception("CourseId " + courseId + " not found");
		}
		else {
			batch.setCourse(courseRepository.findById(courseId).get());
			batch.setBatchId(batchId);
			return batchRepository.save(batch);
		}
	}
	
	public Boolean deleatBatch(Long batchId) {
		try {
			batchRepository.deleteById(batchId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Boolean deleatByCourse(Long courseId) {
		try {
			batchRepository.deleteByCourse(courseRepository.findById(courseId).get());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
