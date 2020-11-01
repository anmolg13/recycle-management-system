package com.cognizant.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.AdminDao;
import com.cognizant.model.BuyerRequest;
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
	
	public void generateReportForBuyer(LocalDate date1, LocalDate date2) throws Exception{
		admin.generateReportForBuyer(date1, date2);
	}
	
	public List<BuyerRequest> viewReportForBuyer(LocalDate date1, LocalDate date2){
		List<BuyerRequest> orders=admin.viewReportForBuyer(date1, date2);
		return orders;
	}
	
	public List<VendorRequest> getRequestsBetweenTwoDates(LocalDate startdate, LocalDate enddate) {
		List<VendorRequest> vRequestsBetweenTwoDates=admin.getVendorRequestsBetweenTwoDates(startdate,enddate);
		return vRequestsBetweenTwoDates;
	}
}
