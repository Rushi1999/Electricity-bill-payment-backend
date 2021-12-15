package com.cg.spring.boot.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bill_table")
public class Bill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "reading", referencedColumnName = "readingId")
	private Reading reading;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	@Column
	private LocalDate billDate;

	@Column
	private LocalDate billDueDate;
	
	@Column
	private int unitsConsumed;
	
	@Column
	private int billAmount;

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bill(Long billId, Reading billForReading, LocalDate billDate, LocalDate billDueDate, int unitsConsumed,
			int billAmount) {
		super();
		this.billId = billId;
		this.reading = billForReading;
		this.billDate = billDate;
		this.billDueDate = billDueDate;
		this.unitsConsumed = unitsConsumed;
		this.billAmount = billAmount;
	}

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Reading getBillForReading() {
		return reading;
	}

	public void setBillForReading(Reading billForReading) {
		this.reading = billForReading;
	}

	public LocalDate getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}

	public LocalDate getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(LocalDate billDueDate) {
		this.billDueDate = billDueDate;
	}

	public int getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(int unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public int getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(int billAmount) {
		this.billAmount = billAmount;
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billForReading=" + reading + ", billDate=" + billDate
				+ ", billDueDate=" + billDueDate + ", unitsConsumed=" + unitsConsumed + ", billAmount=" + billAmount
				+ "]";
	}
	
	 

}
