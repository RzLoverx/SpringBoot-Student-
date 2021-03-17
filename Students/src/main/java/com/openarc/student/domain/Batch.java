package com.openarc.student.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="batch")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="batch_id")
	private Long batchId;
	private Date startingDate;
	private String batchNo;
	private Date finishingDate;
	private String status;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="course_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Course course;
	
	public Long getBatchId() {
		return batchId;
	}
	
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
		
	public Date getStartingDate() {
		return startingDate;
	}
	
	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}
	
	public String getBatchNo() {
		return batchNo;
	}
	
	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public Date getFinishingDate() {
		return finishingDate;
	}
	
	public void setFinishingDate(Date finishingDate) {
		this.finishingDate = finishingDate;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
			
}
