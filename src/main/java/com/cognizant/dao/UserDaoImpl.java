package com.cognizant.dao;

import java.sql.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.BuyerRequest;
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
		Random id=new Random();
		int userId = id.nextInt(100000);
		user.setId(userId);
		String query="insert into user values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getEmail()+"','"+user.getPhoneNumber()+"','"+user.getPassword()+"','"+user.getGender()+"',"+user.getId()+")";
		return template.update(query);
	}
    
	public String validate(String email){    
	    String sql="select password from user where email= '"+email+"'"; 
	    String password=template.queryForObject(sql, String.class);
	    return password;    
	}
	
	public int insertBuyerRequest(BuyerRequest buyerRequest, String email) {
		Random requestId=new Random();
		int rid = requestId.nextInt(100000);
		buyerRequest.setRequestId(rid);
		String query1="select * from user where email= '"+email+"'";
		User user = (User) template.queryForObject(query1, new BeanPropertyRowMapper(User.class));
		//System.out.print(user.getId());
		int id=user.getId();
		java.sql.Date date=new Date(buyerRequest.getPaymentDate().getTime());
		java.util.Date todayDate=new java.util.Date();
		java.sql.Date requestDate = new java.sql.Date(todayDate.getTime());
		
		buyerRequest.setPaidAmount(0);
		String query="insert into buyer_request values("+buyerRequest.getRequestId()+",'"+email+"',"+buyerRequest.getQuantity()+","+buyerRequest.getAmount()+",'"+buyerRequest.getLocation()+"','"+requestDate+"','"+date+"','2020-11-02','Order Received',"+buyerRequest.getPaidAmount()+","+id+")";
		return template.update(query);
		}
}