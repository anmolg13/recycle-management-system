package com.cognizant.dao;

import java.time.LocalDate;
import java.util.List;

import com.cognizant.model.VendorRequest;

public interface AdminDao {

	public int validate(String username,String password);
	public List<VendorRequest> getVendorRequests(LocalDate localDate);
}
