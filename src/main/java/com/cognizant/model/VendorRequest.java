package com.cognizant.model;

import java.util.Date;

public class VendorRequest {
	private int requestId;
	private String vendorEmail;
	private String typeOfOrg;
	private int amount;
	private String location;
	private Date requestDate;
	private Date requiredDate;
	private String status;
	private Date time;
	private int vendorId;
	public VendorRequest(int requestId, String vendorEmail, String typeOfOrg, int amount, String location,
			Date requestDate, Date requiredDate, String status, Date time, int vendorId) {
		super();
		this.requestId = requestId;
		this.vendorEmail = vendorEmail;
		this.typeOfOrg = typeOfOrg;
		this.amount = amount;
		this.location = location;
		this.requestDate = requestDate;
		this.requiredDate = requiredDate;
		this.status = status;
		this.time = time;
		this.vendorId = vendorId;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getVendorEmail() {
		return vendorEmail;
	}
	public void setVendorEmail(String vendorEmail) {
		this.vendorEmail = vendorEmail;
	}
	public String getTypeOfOrg() {
		return typeOfOrg;
	}
	public void setTypeOfOrg(String typeOfOrg) {
		this.typeOfOrg = typeOfOrg;
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
	public Date getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	public Date getRequiredDate() {
		return requiredDate;
	}
	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getVendorId() {
		return vendorId;
	}
	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}
}
