package com.openarc.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.openarc.student.domain.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
