package com.openarc.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.openarc.student.domain.Student;
import com.openarc.student.services.StudentService;


@RestController
@RequestMapping
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping(value = "/student")
	private Student creatStudent(@RequestBody Student student) {
		return studentService.creatStudent(student);
	}
	
	@PutMapping(value = "/student/{studentId}")
	private Student updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
		return studentService.updateStudent(studentId, student);
	}
	
	@DeleteMapping(value = "/student/{studentId}")
	private boolean deleatStudent(@PathVariable Long studentId) {
		return studentService.deleatStudent(studentId);
	}

	@GetMapping(value="/student/{studentId}")
	private Student getStudent(@PathVariable Long studentId) {
		return studentService.getStudent(studentId);
	}
	
	@GetMapping(value = "/students")
	private List<Student> getAllStudents(){
		return studentService.getAllStudents();
	}
}
