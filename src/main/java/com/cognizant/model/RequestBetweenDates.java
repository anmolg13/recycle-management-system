package com.cognizant.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class RequestBetweenDates {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fromDate;
	public LocalDate getFromDate() {
		return fromDate;
	}
	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}
	public LocalDate getToDate() {
		return toDate;
	}
	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate toDate;

}
