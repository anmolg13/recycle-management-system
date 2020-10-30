package com.cognizant.dao;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.User;
import com.cognizant.model.VendorRequest;

public interface UserDao {    
    
	public int insertIntoDb(User user);
	public String validate(String email);
	public int insertVendorRequest(VendorRequest request,String email);
	public int insertBuyerRequest(BuyerRequest buyerRequest, String email);
}