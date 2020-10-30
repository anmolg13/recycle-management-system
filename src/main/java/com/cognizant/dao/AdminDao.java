package com.cognizant.dao;

import java.util.List;

import com.cognizant.model.BuyerRequest;

public interface AdminDao {

	public String validate(String username);
	public List<BuyerRequest> viewBuyerOrders();
}
