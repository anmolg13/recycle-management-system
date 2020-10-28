package com.cognizant.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.User;

@Component
public class UserDaoImpl implements UserDao{
	@Autowired
    JdbcTemplate template;
    
	public JdbcTemplate getJdbcTemplate() {
		return template;
	}
	
	public void setTemplate(JdbcTemplate template) {    
	    this.template = template;    
	}  
	
	public int insertIntoDb(User user) {
		String query="insert into user values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPhoneNumber()+"','"+user.getPassword()+"','"+user.getGender()+"',"+user.getId()+")";
		return template.update(query);
	}
    
	public String validate(String email){    
	    String sql="select password from user where email="+email; 
	    String password=template.queryForObject(sql, String.class);
	    return password;    
	}

}