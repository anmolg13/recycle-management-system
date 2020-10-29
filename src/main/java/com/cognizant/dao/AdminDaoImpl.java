package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminDaoImpl implements AdminDao {
    
	@Autowired
	JdbcTemplate template;
	
	@Override
	public String validate(String username) {
		String sql="select password from admin where username=\""+username+"\""; 
	    String password=template.queryForObject(sql, String.class);	    
	    return password;
	    
	}

}
