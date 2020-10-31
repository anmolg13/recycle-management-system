package com.cognizant.dao;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.User;
import com.cognizant.model.VendorRequest;

@Component
public class UserDaoImpl implements UserDao {
	@Autowired
	JdbcTemplate template;

	public JdbcTemplate getJdbcTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public int insertIntoDb(User user) {
		Random id = new Random();
		int userId = id.nextInt(100000);
		user.setId(userId);
		String query = "insert into user values('" + user.getFirstName() + "','" + user.getLastName() + "','"
				+ user.getEmail() + "','" + user.getPhoneNumber() + "','" + user.getPassword() + "','"
				+ user.getGender() + "'," + user.getId() + ")";
		return template.update(query);
	}

	public int validate(String email, String password) {
		String sql = "select count(*) from user where email='" + email + "' and password='" + password + "'";
		int check = template.queryForObject(sql, Integer.class);
		return check;
	}

	public int insertVendorRequest(VendorRequest vendorRequest, String email) {
		Random requestId = new Random();
		int rid = requestId.nextInt(100000);
		vendorRequest.setRequestId(rid);
		String query1 = "select * from user where email= '" + email + "'";
		User user = (User) template.queryForObject(query1, new BeanPropertyRowMapper(User.class));
		// System.out.print(user.getId());
		int id = user.getId();
		LocalDate requestDate = LocalDate.now();
		String time = vendorRequest.getTime();
		time = time.replaceAll(":", "");
		String query = "insert into vendor_request values(" + vendorRequest.getRequestId() + ",'" + email + "','"
				+ vendorRequest.getTypeOfOrg() + "'," + vendorRequest.getAmount() + ",'" + vendorRequest.getLocation()
				+ "','" + requestDate + "','" + vendorRequest.getRequiredDate() + "','New','" + time + "'," + id + ")";
		return template.update(query);
	}

	public int insertBuyerRequest(BuyerRequest buyerRequest, String email) {
		Random requestId = new Random();
		int rid = requestId.nextInt(100000);
		buyerRequest.setRequestId(rid);
		String query1 = "select * from user where email= '" + email + "'";
		User user = (User) template.queryForObject(query1, new BeanPropertyRowMapper(User.class));
		// System.out.print(user.getId());
		int id = user.getId();
		LocalDate date = LocalDate.now();
		buyerRequest.setPaidAmount(0);
		String query = "insert into buyer_request values(" + buyerRequest.getRequestId() + ",'" + email + "',"
				+ buyerRequest.getQuantity() + "," + buyerRequest.getAmount() + ",'" + buyerRequest.getLocation()
				+ "','" + date + "','" + buyerRequest.getRequiredDate() + "','2020-11-02','Order Received',"
				+ buyerRequest.getPaidAmount() + "," + id + ")";
		return template.update(query);
	}

	public List<BuyerRequest> fetchRecords(String email) {
		String query1 = "select * from buyer_request where buyer_email= '" + email + "'";
		List<BuyerRequest> request = template.query(query1, new BeanPropertyRowMapper(BuyerRequest.class));
		return request;
	}

	public String checkStatus(int requestId) {
		String query1 = "select * from buyer_request where request_id= " + requestId;
		BuyerRequest request = (BuyerRequest) template.queryForObject(query1,
				new BeanPropertyRowMapper(BuyerRequest.class));
		return request.getStatus();
	}

	public int updatePayment(BuyerRequest buyerRequest, String email, int amount) {

		int rid = buyerRequest.getRequestId();
		LocalDate date = LocalDate.now();
		String query = null;
		boolean flag = false;
		int x = buyerRequest.getRequiredDate().compareTo(date);
		if (x == 0)
			flag = true;
		if (buyerRequest.getQuantity() < 10 && flag)
			query = "update buyer_request set status='Shipped',paid_amount=" + amount + ",payment_date='" + date
					+ "' where request_id=" + rid;
		else if ((buyerRequest.getQuantity() < 10))
			query = "update buyer_request set status='Order Ready',paid_amount=" + amount + ",payment_date='" + date
					+ "' where request_id=" + rid;
		else
			query = "update buyer_request set paid_amount=" + amount + ",payment_date='" + date + "' where request_id="
					+ rid;
		return template.update(query);
	}

	public int updatePayment2(int requestId, int amount) {

		LocalDate date = LocalDate.now();
		String query = "update buyer_request set status='Shipped',paid_amount=" + amount + ",payment_date='" + date
				+ "' where request_id=" + requestId;
		return template.update(query);
	}
}