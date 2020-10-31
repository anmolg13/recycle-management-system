package com.cognizant.dao;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Manager;
import com.cognizant.model.VendorRequest;

@Repository
public class ManagerDaoImpl implements ManagerDao {
	
	 @Autowired
    JdbcTemplate jdbcTemplate;  
	
	 @Override
	public int saveManager(Manager m)
	{  
		String insertQuery = "insert into manager (first_name, last_name, email, phone_number, password, gender, skills, approved) values (?, ?, ?, ?, ?, ?, ?, ?)";
	    int executed =  jdbcTemplate.update( insertQuery, m.getFirstName(), m.getLastName(), m.getEmail(), m.getContact() ,m.getPassword(), m.getGender(), m.getSkill(), "Yes");
	    return executed;
	}

    @Override
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


	@Override
	public List getVendorRequests() {
	    List<VendorRequest> requests = new ArrayList<>();
	    
	    String selectQuery = "select request_id, vendor_email, type_of_org, amount, location, req_date, when_date, status, time, vendor_id from vendor_request";
	    
	    requests = jdbcTemplate.query(selectQuery,
	            (rs, rowNum) ->
              new VendorRequest(
              rs.getInt("request_id"),
              rs.getString("vendor_email"),
              rs.getString("type_of_org"),
              rs.getInt("amount"),
              rs.getString("location"),
              LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("req_date"))),
              LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("when_date"))),
              rs.getString("status"),
              rs.getString("time"),
              rs.getInt("vendor_id")
        )
);
	    
		return requests;
	}


	@Override
	public int changeStatus(int requestId, String status) {
		String updateQuery = "update vendor_request set status='"+status+"' where request_id ="+requestId;
		
		int affectedRows =  jdbcTemplate.update(updateQuery);
		
		return affectedRows;
		
	}  
	
	

}
