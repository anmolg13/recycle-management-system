package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.ManagerDao;
import com.cognizant.model.Manager;

@Service
public class ManagerService {

	@Autowired
	ManagerDao managerdao;
	
	public void saveManager(Manager manager)
	{
		managerdao.saveManager(manager);
	}
	
	public boolean checkManagerCredentials(String email, String password)
	{
		return managerdao.checkManagerCredentials(email, password);
	}
	
	public List getVendorRequests()
	{
		return managerdao.getVendorRequests();
	}
	
	public int changeStatus(int requestId, String status)
	{
		return managerdao.changeStatus(requestId, status);
	}
	
	public List getManagerDetails()
	{
		return managerdao.getManagerDetails();
	}
	
	public int changeManagerApproval(String email, String approve)
	{
		return managerdao.changeApproval(email, approve);
	}
}
