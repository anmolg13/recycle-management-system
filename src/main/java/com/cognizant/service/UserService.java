package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDao;
import com.cognizant.model.User;

@Service
public class UserService {
	@Autowired    
    UserDao userDao;
	
	public void insertIntoDb(User user) {
		userDao.insertIntoDb(user);
	}
	
	public boolean validateUser(String email,String password) {
		String pass=userDao.validate(email);
		if(password!=null && password.equals(pass))
			return true;
		else return false;
	}

}