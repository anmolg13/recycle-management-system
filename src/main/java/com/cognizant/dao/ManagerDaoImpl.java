package com.cognizant.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Manager;

@Repository
public class ManagerDaoImpl implements ManagerDao {
	
	 @Autowired
    JdbcTemplate jdbcTemplate;  
	
	public int saveManager(Manager m)
	{  
		String insertQuery = "insert into manager (first_name, last_name, email, phone_number, password, gender, skills, approved) values (?, ?, ?, ?, ?, ?, ?, ?)";
	    int executed =  jdbcTemplate.update( insertQuery, m.getFirstName(), m.getLastName(), m.getEmail(), m.getContact() ,m.getPassword(), m.getGender(), m.getSkill(), "Yes");
	    return executed;
	}


	public boolean checkManagerCredentials(String email, String password) {
		String selectQuery = "select count(*) from manager where email='"+email+"' and password='"+password+"' and approved='yes'";
		int i = jdbcTemplate.queryForObject(selectQuery, Integer.class);
		if(i==1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}  
	
	

}
