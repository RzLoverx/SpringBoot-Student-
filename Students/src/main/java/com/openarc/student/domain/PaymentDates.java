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
@Table(name="paymentdates")
public class PaymentDates {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="paymentDate_id")
	private long paymentDateId;
	private Date paymentDate;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="batch_id", nullable=false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Batch batch;
	
	public long getPaymentDateId() {
		return paymentDateId;
	}
	
	public void setPaymentDateId(long paymentDateId) {
		this.paymentDateId = paymentDateId;
	}
	
	public Date getPaymentDate() {
		return paymentDate;
	}
	
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public Batch getBatch() {
		return batch;
	}

	public void setBatch(Batch batch) {
		this.batch = batch;
	}
	
}
