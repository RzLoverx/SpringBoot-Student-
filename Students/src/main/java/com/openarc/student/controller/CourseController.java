package com.openarc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.openarc.student.domain.Course;
import com.openarc.student.services.CourseService;

public class CourseController {
	
	@Autowired
	CourseService courseService;
	
	@PostMapping(value = "/course")
	private Course creatCourse(@RequestBody Course course) {
		return courseService.creatCourse(course);
	}
	
	@PutMapping(value = "/course/{couseId}")
	private Course updateCourse(@PathVariable Long courseId, @RequestBody Course course) throws Exception {
		return courseService.updateCourse(courseId,course);
	}

	@DeleteMapping(value = "/course/{couseId}")
	private Boolean deletCourse(@PathVariable Long courseId) {
		return courseService.deletCourse(courseId);
	}
	
	@GetMapping(value = "/course/{couseId}")
	private Course getCourse(@PathVariable Long courseId) {
		return courseService.getCourse(courseId);
	}
	
	@GetMapping(value = "/courses")
	private List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
}

