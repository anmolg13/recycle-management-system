package com.cognizant.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.model.User;
import com.cognizant.service.UserService;


@Controller
@SessionAttributes("email")
public class UserController {
	@Autowired
	private UserService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@ModelAttribute("genderList")
	public List<String> genderList(){
		List<String> list=new ArrayList<>();
		list.add("----Select----");
		list.add("Male");
		list.add("Female");
		return list;
	}
	
	@RequestMapping(value="/UserHomePage",method=RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "user";
	}
	
	@RequestMapping(value="/RegisterUser",method=RequestMethod.GET)
	public String registrationPage(@ModelAttribute("user") User user) {
		System.out.print("Here");
		return "user-registration";
	}
	
	@RequestMapping(value="/RegisterUser", method=RequestMethod.POST)
	public String registrationValidation(@Valid @ModelAttribute("user") User user,BindingResult result,ModelMap model) {
		LOGGER.info("Start");
		if(result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			LOGGER.info("end");
			return "user-registration";
			
		}
		else {
			service.insertIntoDb(user);
			LOGGER.info("end");
			return "user-registration-successful";
		}
	}
	
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

