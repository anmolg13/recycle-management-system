package com.cognizant.controller;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cognizant.model.BuyerRequest;
import com.cognizant.model.User;
import com.cognizant.model.VendorRequest;
import com.cognizant.service.UserService;


@Controller
@SessionAttributes("User")
public class UserController {
	@Autowired
	private UserService service;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, false));
	}
	
	@ModelAttribute("genderList")
	public List<String> genderList(){
		List<String> list=new ArrayList<>();
		list.add("----Select----");
		list.add("Male");
		list.add("Female");
		return list;
	}
	
	@RequestMapping(value="/homePage",method=RequestMethod.GET)
	public String homePage(ModelMap model) {
		return "homePage";
	}
	
	@RequestMapping(value="/userHomePage",method=RequestMethod.GET)
	public String userHomePage(ModelMap model) {
		return "user";
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.GET)
	public String registrationPage(@ModelAttribute("user") User user) {
		return "userRegistration";
	}
	
	@RequestMapping(value="/registerUser", method=RequestMethod.POST)
	public String registrationValidation(@Valid @ModelAttribute("user") User user,BindingResult result,ModelMap model) {
		LOGGER.info("Start");
		if(result.hasErrors()) {
			System.out.println("errors");
			System.out.println(result.getAllErrors());
			LOGGER.info("end");
			return "userRegistration";
			
		}
		else {
			service.insertIntoDb(user);
			LOGGER.info("end");
			return "userRegistrationSuccessful";
		}
	}
	
	@RequestMapping(value="/loginUser",method=RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
		//model.put("name",name);
		return "loginUser";
	}
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public String showWelcomePage(ModelMap model,@ModelAttribute("user") User user) {
		boolean isValidUser=service.validateUser(user.getEmail(), user.getPassword());
		if(!isValidUser)
			{
			model.put("message","invalid Credentials");
			return "loginUser";
			}
		
		//model.put("name",email);
		//model.put("password",password);
		model.put("User", user);
		return "welcomeUser";
	}
	
	@RequestMapping(value="/buyer",method=RequestMethod.GET)
	public String buyerHomePage(@ModelAttribute("buyerRequest") BuyerRequest buyerRequest) {
		return "buyerHomePage";
	}
	
	@RequestMapping(value="/buyer",method=RequestMethod.POST)
	public String buyerHomePage(@ModelAttribute("buyerRequest") BuyerRequest buyerRequest, ModelMap model) {
		User user=(User)model.get("User");
		String message;
		if(buyerRequest.getQuantity()<10)
		{
			message="We can serve your request today.";
		}
		else if(buyerRequest.getQuantity()>=10 && buyerRequest.getQuantity()<20)
		{
			message="We can serve your request in 2 days.";
		}
		else 
		{
			message="We can serve your request in 4 days.";
		}
//		else {
//			model.put("msg","Maximum quantity allowed is 50 kg!!");
//			return "buyerHomePage";
//		}
		model.put("msg", message);
		int quantity=buyerRequest.getQuantity();
		//System.out.print("Qty"+quantity);
		int amount=quantity*50;
		buyerRequest.setAmount(amount);
		model.put("amount", buyerRequest.getAmount());
		service.insertBuyerRequest(buyerRequest,user.getEmail());
		return "displayBuyerDetails";
	}
	
	@RequestMapping(value="/vendorRequest",method=RequestMethod.GET)
	public String vendorRequestPage(@ModelAttribute("request") VendorRequest request) {
		return "vendorRequestForm";
	}
	
	@RequestMapping(value="/welcomeUser", method=RequestMethod.POST)
	public String vendorRequestToDB( @ModelAttribute("request") VendorRequest request,ModelMap model) {
		    User user=(User)model.get("User");
			service.insertVendorRequest(request,user.getEmail());			
			return "welcomeUser";
		
	}

}

