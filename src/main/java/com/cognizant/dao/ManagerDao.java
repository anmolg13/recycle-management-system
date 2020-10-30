package com.cognizant.dao;

import com.cognizant.model.Manager;

public interface ManagerDao {

	public int saveManager(Manager m);
	
	public boolean checkManagerCredentials(String email, String password);
}
