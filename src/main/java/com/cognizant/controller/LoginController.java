package com.cognizant.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.service.LoginService;


@Controller
@SessionAttributes("email")
public class LoginController {
	@Autowired
	LoginService service;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		//model.put("name",name);
		return "login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model,@RequestParam String email,@RequestParam String password) {
		boolean isValidUser=service.validateUser(email, password);
		if(!isValidUser)
			{
			model.put("message","invalid Credentials");
			return "login";
			}
		
		//model.put("name",email);
		//model.put("password",password);
		return "welcome";
	}

}

