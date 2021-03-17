package com.openarc.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="course_id")
	private Long courseId;
	private String courseCode;
	private String courseName;
	private int noOfInstallment;
	
	public long getCourseId() {
		return courseId;
	}
	
	public void setCourseId(long courseID) {
		this.courseId = courseID;
	}
	
	public String getCourseCode() {
		return courseCode;
	}
	
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}
	
	public String getCourseName() {
		return courseName;
	}
	
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public int getNoOfInstallment() {
		return noOfInstallment;
	}
	
	public void setNoOfInstallment(int noOfInstallment) {
		this.noOfInstallment = noOfInstallment;
	}
	
	
	
}
