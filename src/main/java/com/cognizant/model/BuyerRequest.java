package com.cognizant.model;

import java.util.Date;

public class BuyerRequest {
	private int requestId;
	private String buyerEmail;
	private int amount;
	private String location;
	private Date paymentDate;
	private String status;
	private int paidAmount;
	private int buyerId;
	
	public BuyerRequest(int requestId, String buyerEmail, int amount, String location, Date paymentDate, String status,
			int paidAmount, int buyerId) {
		super();
		this.requestId = requestId;
		this.buyerEmail = buyerEmail;
		this.amount = amount;
		this.location = location;
		this.paymentDate = paymentDate;
		this.status = status;
		this.paidAmount = paidAmount;
		this.buyerId = buyerId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(int paidAmount) {
		this.paidAmount = paidAmount;
	}
	public int getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(int buyerId) {
		this.buyerId = buyerId;
	}
}