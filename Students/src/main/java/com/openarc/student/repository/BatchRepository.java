package com.openarc.student.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openarc.student.domain.Batch;
import com.openarc.student.domain.Course;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long>{
	
	
	List<Batch> findByCourse(Course course ,Sort sort);
	
	Void deleteByCourse(Course course);

}
