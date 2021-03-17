package com.openarc.student.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.Course;
import com.openarc.student.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository courseRepository;
	
	public Course creatCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Course updateCourse(Long courseId,Course course) throws Exception {
		if(!courseRepository.existsById(courseId)) {
			throw new Exception("CourseId " + courseId + " not found");
		}
		else {
			course.setCourseId(courseId);
			return courseRepository.save(course);
		}
	}
	
	public Boolean deletCourse(Long courseId) {
		try {
			courseRepository.deleteById(courseId);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public Course getCourse(Long courseId) {
		return courseRepository.findById(courseId).get();
	}

	public List<Course> getAllCourses() {
		return courseRepository.findAll();
	}
}
