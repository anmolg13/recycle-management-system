package com.cognizant.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cognizant.model.BuyerRequest;

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

	public List<BuyerRequest> viewBuyerOrders() {
		String sql="select * from buyer_request order by buyer_id ";
		List<BuyerRequest> orders=template.query(sql, new BeanPropertyRowMapper(BuyerRequest.class));
		return orders;
	}
}
