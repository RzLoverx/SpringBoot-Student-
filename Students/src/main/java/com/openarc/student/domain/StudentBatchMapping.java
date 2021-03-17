package com.openarc.student.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class StudentBatchMapping {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="studentBatchMapping_id")
	private Long studentBatchMappingId;
	private String status;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="student_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Student student;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="batch_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Batch batch;
	
	public Long getStudentBatchMappingId() {
		return studentBatchMappingId;
	}
	
	public void setStudentBatchMappingId(Long studentBatchMappingId) {
		this.studentBatchMappingId = studentBatchMappingId;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
}
