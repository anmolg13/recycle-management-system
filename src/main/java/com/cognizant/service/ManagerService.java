package com.cognizant.service;

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
}
