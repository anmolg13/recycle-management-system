package com.cognizant.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.dao.ManagerDaoImpl;
import com.cognizant.model.Manager;

@Controller
public class ManagerController {

	@Autowired
	Manager man;
	
	@Autowired
	ManagerDaoImpl mandao;
	
	@RequestMapping(value="/managerReg")
	public String str()
	{
		return "managerReg";
	}
	
	@RequestMapping(value="/managerRegForm")
	public String klo(Model m)
	{
		m.addAttribute("manager", man);
		return "managerRegForm";
	}
	
	
	@RequestMapping(value="/submitForm")
	public String ght(@Valid @ModelAttribute("manager") Manager mg, BindingResult br)
	{
		    if(br.hasErrors())  
	        {  
		   // 	System.out.println(br.getFieldError());
		   // 	System.out.println("here");
			 return "managerRegForm";
	        }  
	        else  
	        {  
	       // System.out.println("here1");
	     //   System.out.println("here12");
	      System.out.println("here13");
	        int status=mandao.saveManager(mg);  
	      //  System.out.println(status);  
	        return "managerSuccess";  
	        }  
		
	}
	
}