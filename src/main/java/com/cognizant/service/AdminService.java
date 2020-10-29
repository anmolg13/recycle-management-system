package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.dao.AdminDao;

@Component
public class AdminService {
    
	@Autowired
	AdminDao admin;
	
	public boolean validateAdmin(String username,String password) {
		String pass=admin.validate(username);
		if(password!=null && password.equals(pass))
			return true;
		else return false;
	}
}
