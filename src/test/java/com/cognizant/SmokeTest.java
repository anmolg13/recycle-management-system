package com.cognizant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.controller.AdminController;
import com.cognizant.controller.ManagerController;
import com.cognizant.controller.UserController;
import com.cognizant.controller.WelcomeController;

@SpringBootTest
public class SmokeTest {

	@Autowired
	private WelcomeController welcomeController;
	
	@Autowired
	private AdminController adminController;
	
	@Autowired
	private UserController userController;

	@Autowired
	private ManagerController managerController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(welcomeController).isNotNull();
		assertThat(adminController).isNotNull();
		assertThat(userController).isNotNull();
		assertThat(managerController).isNotNull();
	}
}
