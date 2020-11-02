package com.cognizant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.UserDao;
import com.cognizant.model.BuyerRequest;
import com.cognizant.model.User;
import com.cognizant.model.VendorRequest;

@Service
public class UserService {
	@Autowired    
    UserDao userDao;
	
	public void insertIntoDb(User user) {
		userDao.insertIntoDb(user);
	}
	
	public boolean validateUser(String email,String password) {
		int check=userDao.validate(email,password);
		if(check>=1)
			return true;
		else return false;
	}
	
	public void insertVendorRequest(VendorRequest request,String email) {
		userDao.insertVendorRequest(request,email);
	}
	
	public void insertBuyerRequest(BuyerRequest buyerRequest,String email, int amount) {
		userDao.insertBuyerRequest(buyerRequest,email,amount);
	}
	
	public List<BuyerRequest> fetchRecords(String email){
		List<BuyerRequest> records=userDao.fetchRecords(email);
		return records;
	}
	
	public String checkStatus(int requestId) {
		String status=userDao.checkStatus(requestId);
		return status;
	}

//        public void updatePayment(BuyerRequest buyerRequest,String email,int amount) {
//		userDao.updatePayment(buyerRequest,email,amount);
//	}
        
        public void updatePayment2(int requestId,int amount) {
    		userDao.updatePayment2(requestId,amount);
    	}

}