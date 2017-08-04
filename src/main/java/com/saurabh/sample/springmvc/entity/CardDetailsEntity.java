package com.saurabh.sample.springmvc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARDDETAILS")
public class CardDetailsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CARDNUMBER")
	private long cardNumber;

	@Column(name = "STARTDATE")
	private long startDate;

	@Column(name = "EXPIRYDATE")
	private long expiryDate;

	@Column(name = "BOOKLIMIT")
	private long booksLimit;

	@Column(name = "DUEAMOUNT")
	private double dueAmount;

	public long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public long getStartDate() {
		return startDate;
	}

	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}

	public long getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(long expiryDate) {
		this.expiryDate = expiryDate;
	}

	public long getBooksLimit() {
		return booksLimit;
	}

	public void setBooksLimit(long booksLimit) {
		this.booksLimit = booksLimit;
	}

	public double getDueAmount() {
		return dueAmount;
	}

	public void setDueAmount(double dueAmount) {
		this.dueAmount = dueAmount;
	}

}
