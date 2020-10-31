package com.cognizant.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.AdminDao;
import com.cognizant.model.VendorRequest;

@Component
public class AdminService {
    
	@Autowired
	AdminDao admin;
	
	public boolean validateAdmin(String username,String password) {
		int check=admin.validate(username,password);
		if(check>=1)
			return true;
		else return false;
	}
	

	public List<VendorRequest> getRequests(LocalDate localDate) {
		List<VendorRequest> vRequests=admin.getVendorRequests(localDate);
		return vRequests;
		
	}
}
