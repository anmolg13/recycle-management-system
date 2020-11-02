package com.cognizant.model;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	
	//@Size(min=3,max=15,message="First Name should contain 3-15 characters ")
	private String firstName;
	//@Size(min=3,max=15,message="Last Name should contain 3-15 characters ")
	private String lastName;
	//@Size(min=10,max=10,message="Phone Number should contain 10 characters")
	private String phoneNumber;
	//@Pattern(regexp="(?=.*[@])",message="Email should contain @ symbol")
	private String email;
	//@Size(min=6, message="Password should contain 6 characters")
    //@Pattern(regexp="[0-9@#$!]+",message="Password should contain digits and special characters")
	private String password;
	private String gender;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
}