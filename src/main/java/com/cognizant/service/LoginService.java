package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cognizant.UserDao;

@Component
public class LoginService {
	@Autowired    
    UserDao ud;
	public boolean validateUser(String email,String password) {
		String pass=ud.validate(email);
		if(password!=null && password.equals(pass))
			return true;
		else return false;
	}

}