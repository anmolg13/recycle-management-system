package com.cognizant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cognizant.model.VendorRequest;

@Repository
public class AdminDaoImpl implements AdminDao {
    
	@Autowired
	JdbcTemplate template;
	
	public int validate(String username,String password) {
		String sql="select count(*) from admin where username='"+username+"' and password='"+password+"'"; 
	    int check=template.queryForObject(sql, Integer.class);	    
	    return check;
	    
	}
	
	public List<VendorRequest> getVendorRequests(LocalDate req_date_from_web) {	

		return template.query("select * from vendor_request where req_date='"+req_date_from_web+"'", new ResultSetExtractor<List<VendorRequest>>() {

			public List<VendorRequest> extractData(ResultSet rs) throws SQLException{

				List<VendorRequest> list = new ArrayList<VendorRequest>();
				while (rs.next()) {
					VendorRequest v= new VendorRequest();
					v.setRequestId(rs.getInt(1));
					v.setVendorEmail(rs.getString(2));
					v.setTypeOfOrg(rs.getString(3));
					v.setAmount(rs.getInt(4));
					v.setLocation(rs.getString(5));
					v.setRequestDate(rs.getDate(6).toLocalDate());
					v.setRequiredDate(rs.getDate(7).toLocalDate());
					v.setStatus(rs.getString(8));
					v.setTime(rs.getTime(9).toString());
					v.setVendorId(rs.getInt(10));
					list.add(v);
				}
				return list;
			}
		});

	}
}
