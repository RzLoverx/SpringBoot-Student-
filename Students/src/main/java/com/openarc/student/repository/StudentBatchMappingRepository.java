package com.openarc.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openarc.student.domain.Batch;
import com.openarc.student.domain.Student;
import com.openarc.student.domain.StudentBatchMapping;

@Repository
public interface StudentBatchMappingRepository extends JpaRepository<StudentBatchMapping, Long> {
	
	List<StudentBatchMapping> findByStudent(Student student);
	
	List<StudentBatchMapping> findByBatch(Batch batch);
	
	void deleteByStudent(Student student);
	
	void deleteByBatch(Batch batch);

}
