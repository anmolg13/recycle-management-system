package com.cognizant.controller;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.model.BuyerRequest;
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
	
	@RequestMapping(value="/loginAdmin",method=RequestMethod.POST)
	public String showAdminWelcomePage(ModelMap model,@RequestParam String username,@RequestParam String password) {
		boolean isValidUser=adminservice.validateAdmin(username, password);
		if(!isValidUser)
			{
			model.put("message","invalid Credentials");
			return "loginAdmin";
			}
		return "welcomeAdmin";
	}
}

