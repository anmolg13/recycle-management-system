package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.model.Manager;
import com.cognizant.service.ManagerService;

@Controller
public class ManagerController {

	@Autowired
	Manager man;
	
	@Autowired
	ManagerService service;
	
	
	//ManagerRegistration
	@RequestMapping(value="/managerReg")
	public String managerReg()
	{
		return "managerReg";
	}
	
	@RequestMapping(value="/managerRegForm")
	public String managerRegForm(Model m)
	{
		m.addAttribute("manager", man);
		return "managerRegForm";
	}
	
	
	@RequestMapping(value="/submitForm")
	public String saveManagerDetails(@Valid @ModelAttribute("manager") Manager manager, BindingResult bindingresult)
	{
		    if(bindingresult.hasErrors())  
	        {  
			 return "managerRegForm";
	        }  
	        else  
	        {  
	        service.saveManager(manager);  
	        return "managerAddedSuccess";  
	        }  
		
	}
	
	
	//Manager Login
	@RequestMapping(value="/managerlogin")
	public String managerLogin()
	{
		return "managerLogin";
	}
	
	@RequestMapping(value="/validatemanager")
	public String managerCredentialValidation(HttpServletRequest req)
	{
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		if(service.checkManagerCredentials(email, pass))
		{
			return "managerLoginSuccess";
		}
		else
		{
			return "managerLogin";
		}
	}
	
}