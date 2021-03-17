package com.openarc.student.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.openarc.student.domain.Student;
import com.openarc.student.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
			
	public Student creatStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent( Long studentId,  Student student) {
		//studentOld is the record in database 
		Optional<Student> studentOld = studentRepository.findById(studentId);
		if (student.getFirstName().equals(null)||student.getFirstName().equals("")) {
			student.setFirstName(studentOld.get().getFirstName());
		}
		
		if (student.getLastName().equals(null)||student.getLastName().equals("")) {
			student.setLastName(studentOld.get().getLastName());
		}
		
		if (student.getEmail().equals(null)||student.getEmail().equals("")) {
			student.setEmail(studentOld.get().getEmail());
		}
		student.setStudentId(studentId);
		return studentRepository.save(student);
	}
	
	public boolean deleatStudent( Long studentId) {
		studentRepository.deleteById(studentId);
		List<Student> students = studentRepository.findAll();
		Boolean deleat=true;
		for(int x=0;x>students.size();x++) {
			if(students.get(x).getStudentId()==studentId) {
				deleat=false;
				break;
			}
		}
		return deleat;
	}
	
	public Student getStudent(Long studentId) {
		Optional<Student> student = studentRepository.findById(studentId);
		return student.get();
	}
	
	public List<Student> getAllStudents() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
}
