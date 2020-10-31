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

import com.cognizant.model.VendorRequest;
import com.cognizant.service.AdminService;


@Controller
@SessionAttributes("email")
public class AdminController {
	
	@Autowired
	AdminService adminservice;
	
	@RequestMapping(value="/loginAdmin",method=RequestMethod.GET)
	public String showAdminLoginPage(ModelMap model) {
		//model.put("name",name);
		return "loginAdmin";
	}
	
	/* It provides list of requests in model object */
	@RequestMapping(value="/requests",method=RequestMethod.GET)
	public String vendorRequestsDefault(Model m){
		List<VendorRequest> list = adminservice.getRequests(LocalDate.now());
		if(list.isEmpty())
		   System.out.println("Empty List");
		m.addAttribute("list", list);
		m.addAttribute("currentDate",LocalDate.now());
		return "viewRequests";
	}
   
	@RequestMapping(value="/requestOnDate",method=RequestMethod.GET)
	public String vendorRequestsChosen(Model m,@RequestParam("date") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate date ){
		/*
		 * ZoneId defZoneId=ZoneId.systemDefault(); Instant instant=date.toInstant();
		 * LocalDate properDate=instant.atZone(defZoneId).toLocalDate();
		 */
		List<VendorRequest> list = adminservice.getRequests(date);
		if(list.isEmpty())
		   System.out.println("Empty List");
		m.addAttribute("list", list);
		return "viewRequests";
	}
	
	@RequestMapping(value="/loginAdmin",method=RequestMethod.POST)
	public String showAdminWelcomePage(ModelMap model,@RequestParam String username,@RequestParam String password) {
		boolean isValidUser=adminservice.validateAdmin(username, password);
		if(!isValidUser)
			{
			model.put("message","Invalid Credentials");
			return "loginAdmin";
			}
		return "welcomeAdmin";
	}
}

