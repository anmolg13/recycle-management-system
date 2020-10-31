package com.cognizant.dao;

import java.time.LocalDate;
import java.util.List;

import com.cognizant.model.VendorRequest;

public interface AdminDao {

	public String validate(String username);
	public List<VendorRequest> getVendorRequests(LocalDate localDate);
}
