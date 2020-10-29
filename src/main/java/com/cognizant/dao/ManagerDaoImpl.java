package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.Manager;  

@Repository
public class ManagerDaoImpl implements ManagerDao {
	
	 @Autowired
    JdbcTemplate jdbcTemplate;  
	
	public int saveManager(Manager m){  
		System.out.println(m.getGender());
		System.out.println(m.getSkill());
		String insertQuery = "insert into manager (first_name, last_name, email, phone_number, password, gender, skills, approved) values (?, ?, ?, ?, ?, ?, ?, ?)";
	     int i =  jdbcTemplate.update( insertQuery, m.getFirstName(), m.getLastName(), m.getEmail(), m.getContact(), m.getPassword(), m.getGender(), m.getSkill(), "Yes");
	     
	      return i;
	  //  String query="insert into manager values('"+m.getFirstName()+"','"+m.getLastName()+"','"+m.getContact()+"','"+m.getEmail()+"','"+m.getPassword()+"','"+m.getGender()+"','"+m.getSkill()+"','yes')"; 
	  //  return jdbcTemplate.update(query);  
	}  

}
