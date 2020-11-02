package com.cognizant.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.VendorRequest;

@Repository
public class AdminDaoImpl implements AdminDao {

	@Autowired
	JdbcTemplate template;

	public int validate(String username, String password) {
		String sql = "select count(*) from admin where username='" + username + "' and password='" + password + "'";
		int check = template.queryForObject(sql, Integer.class);
		return check;

	}
	
	public List<VendorRequest> getVendorRequests(LocalDate req_date_from_web) {
		String sql = "select * from vendor_request where request_date='" + req_date_from_web + "'";
		List<VendorRequest> list = template.query(sql, new BeanPropertyRowMapper(VendorRequest.class));
		return list;
	}

	@Override
	public List<VendorRequest> getVendorRequestsBetweenTwoDates(LocalDate startdate, LocalDate enddate) {
		String sql = "select * from vendor_request where((required_date between'" + startdate + "' and '" + enddate
				+ "') or (required_date between'" + enddate + "' and '" + startdate + "'))";
		List<VendorRequest> list = template.query(sql, new BeanPropertyRowMapper(VendorRequest.class));
		return list;
	}

	
	public List<BuyerRequest> viewReportForBuyer(LocalDate date1, LocalDate date2){
		String sql = "select * from buyer_request where request_date >= '" + date1 + "' AND request_date<= '" + date2
				+ "'";
		List<BuyerRequest> orders = template.query(sql, new BeanPropertyRowMapper(BuyerRequest.class));
		return orders;
	}

	public void generateReportForBuyer(LocalDate date1, LocalDate date2) throws Exception {
		List<BuyerRequest> orders=viewReportForBuyer(date1, date2);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadsheet = workbook.createSheet("buyer_report");

		XSSFRow row = spreadsheet.createRow(1);
		XSSFCell cell;
		cell = row.createCell(1);
		cell.setCellValue("REQUEST ID");
		cell = row.createCell(2);
		cell.setCellValue("BUYER EMAIL");
		cell = row.createCell(3);
		cell.setCellValue("QUANTITY (IN kg)");
		cell = row.createCell(4);
		cell.setCellValue("AMOUNT");
		cell = row.createCell(5);
		cell.setCellValue("LOCATION");
		cell = row.createCell(6);
		cell.setCellValue("REQUEST DATE");
		cell = row.createCell(7);
		cell.setCellValue("REQUIRED DATE");
		cell = row.createCell(8);
		cell.setCellValue("PAYMENT DATE");
		cell = row.createCell(9);
		cell.setCellValue("STATUS");
		cell = row.createCell(10);
		cell.setCellValue("PAID AMOUNT");
		int i = 2;

		for (BuyerRequest order : orders) {
			row = spreadsheet.createRow(i);
			cell = row.createCell(1);
			cell.setCellValue(order.getRequestId());
			cell = row.createCell(2);
			cell.setCellValue(order.getBuyerEmail());
			cell = row.createCell(3);
			cell.setCellValue(order.getQuantity());
			cell = row.createCell(4);
			cell.setCellValue(order.getAmount());
			cell = row.createCell(5);
			cell.setCellValue(order.getLocation());
			cell = row.createCell(6);
			LocalDate rDate = order.getRequestDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String requestDate = rDate.format(formatter);
			cell.setCellValue(requestDate);
			cell = row.createCell(7);
			LocalDate reqDate = order.getRequestDate();
			String requiredDate = reqDate.format(formatter);
			cell.setCellValue(requiredDate);
			cell = row.createCell(8);
			LocalDate pDate = order.getRequestDate();
			String paymentDate = pDate.format(formatter);
			cell.setCellValue(paymentDate);
			cell = row.createCell(9);
			cell.setCellValue(order.getStatus());
			cell = row.createCell(10);
			cell.setCellValue(order.getPaidAmount());
			i++;
		}
		FileOutputStream out = new FileOutputStream(new File("BUYERS_REPORT.xlsx"));
		workbook.write(out);
		out.close();
		System.out.println("BUYERS_REPORT.xlsx downloaded successfully");
	}
}
