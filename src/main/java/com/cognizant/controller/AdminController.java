package com.cognizant.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.VendorRequest;
import com.cognizant.service.AdminService;

@Controller
@SessionAttributes("email")
public class AdminController {

	@Autowired
	AdminService adminservice;

	@RequestMapping(value = "/adminHomePage", method = RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model) {
		// model.put("name",name);
		return "loginAdmin";
	}

	/* It provides list of requests in model object */
	@RequestMapping(value = "/requests", method = RequestMethod.GET)
	public String vendorRequestsDefault(Model m) {
		List<VendorRequest> list = adminservice.getRequests(LocalDate.now());
		if (list.isEmpty())
			System.out.println("Empty List");
		m.addAttribute("list", list);
		m.addAttribute("currentDate", LocalDate.now());
		return "viewRequests";
	}

	@RequestMapping(value = "/requestOnDate", method = RequestMethod.GET)
	public String vendorRequestsChosen(Model m,
			@RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
		/*
		 * ZoneId defZoneId=ZoneId.systemDefault(); Instant instant=date.toInstant();
		 * LocalDate properDate=instant.atZone(defZoneId).toLocalDate();
		 */
		List<VendorRequest> list = adminservice.getRequests(date);
		if (list.isEmpty())
			System.out.println("Empty List");
		m.addAttribute("list", list);
		return "viewRequests";
	}

	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public String showAdminWelcomePage(ModelMap model, @RequestParam String username, @RequestParam String password) {
		boolean isValidUser = adminservice.validateAdmin(username, password);
		if (!isValidUser) {
			model.put("message", "Invalid Credentials");
			return "loginAdmin";
		}
		return "welcomeAdmin";
	}

	@RequestMapping(value = "/viewReportForBuyer", method = RequestMethod.GET)
	public String generateBuyerReport(ModelMap model) {
		LocalDate today = LocalDate.now();
		model.put("today", today);
		model.put("date1", "");
		model.put("date2", "");
		return "buyerReport";
	}

	@RequestMapping(value = "/viewReportForBuyer", method = RequestMethod.POST)
	public String generateBuyerReport3(@RequestParam("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,
			@RequestParam("date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2, ModelMap model) {
		model.put("date1", date1);
		model.put("date2", date2);
		if (date2.compareTo(date1) <= 0) {
			model.put("status", false);
			model.put("msg", "To date should be greater than From Date");
		} else {
			List<BuyerRequest> orders = adminservice.viewReportForBuyer(date1, date2);
			if (orders.isEmpty()) {
				model.put("msg2", "No Records Found");
			} else {
				model.put("status", true);
				model.put("orders", orders);
			}
		}
		return "buyerReport";
	}

	@RequestMapping(value = "/downloadReportForBuyer", method = RequestMethod.GET)
	public String generateBuyerReport2(ModelMap model,@RequestParam("date1") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date1,
			@RequestParam("date2") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date2, ModelMap mode)
			throws Exception {
		adminservice.generateReportForBuyer(date1, date2);
		model.put("msg", "REPORT HAS BEEN DOWNLOADED AS SHEET buyer_report_"+date1+"-"+date2+" IN BUYERS_REPORT.xlsx");
		return "downloadReport";
	}
	
	@RequestMapping(value = "/datesForWastageReport")
	public String wastageReportHome(Model m) {
		m.addAttribute("yesterday", LocalDate.now().minusDays(1));
		return "wastageReportHome";

	}

	@RequestMapping(value = "/requestBetweenDates", method = RequestMethod.GET)
	public String wastageReport(Model m,
			@RequestParam("startdate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startdate,
			@RequestParam("enddate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate enddate) {
				
		List<VendorRequest> list = adminservice.getRequestsBetweenTwoDates(startdate,enddate);
		if (list.isEmpty())
			System.out.println("Empty List");
		m.addAttribute("list", list);
		return "viewRequestsBetweenTwoDates";

	}
}