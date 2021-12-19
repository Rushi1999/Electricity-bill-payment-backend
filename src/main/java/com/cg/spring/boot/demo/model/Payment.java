package com.cg.spring.boot.demo.model;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "payment_table")
public class Payment {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// should be auto-generated

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	@OneToOne
	@JoinColumn(name = "billId")
	private Bill bill;
	
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	@Column
	private LocalDate paymentDate;
	
	@Column
	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;
	
	@Column
	private double totalPaid;
	
	@Column
	@Enumerated(EnumType.STRING)
	@Pattern(regexp = "^[S|F]{1}$", message ="Must be Success or Failed")
	private PaymentStatus status;
	
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}


	

	public Payment(Customer customer, LocalDate paymentDate, PaymentMode paymentMode, double totalPaid,
			@Pattern(regexp = "^[S|F]{1}$", message = "Must be Success or Failed") PaymentStatus status) {
		super();
		this.customer = customer;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.totalPaid = totalPaid;
		this.status = status;
	}




	public Payment(Long paymentId, Bill bill, LocalDate paymentDate, PaymentMode paymentMode,
			double totalPaid,
			@Pattern(regexp = "^[S|F]{1}$", message = "Must be Success or Failed") PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.bill = bill;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.totalPaid = totalPaid;
		this.status = status;
	}



	public Long getPaymentId() {
		return paymentId;
	}



	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}



	public Bill getBill() {
		return bill;
	}



	public void setBill(Bill bill) {
		this.bill = bill;
	}



	public LocalDate getPaymentDate() {
		return paymentDate;
	}



	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}



	public PaymentMode getPaymentMode() {
		return paymentMode;
	}



	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}


	public double getTotalPaid() {
		return totalPaid;
	}



	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}



	public PaymentStatus getStatus() {
		return status;
	}



	public void setStatus(PaymentStatus status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", bill=" + bill + ", customer=" + customer + ", paymentDate="
				+ paymentDate + ", paymentMode=" + paymentMode + ", totalPaid=" + totalPaid + ", status=" + status
				+ "]";
	}

	
}
