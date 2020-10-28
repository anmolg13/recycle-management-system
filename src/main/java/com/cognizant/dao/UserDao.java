package com.cognizant.dao;

import com.cognizant.model.User;

public interface UserDao {    
    
	public int insertIntoDb(User user);
	public String validate(String email);
}