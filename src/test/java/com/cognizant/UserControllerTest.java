package com.cognizant;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.controller.UserController;
import com.cognizant.dao.UserDao;
import com.cognizant.model.User;
import com.cognizant.service.UserService;

public class UserControllerTest {

	private UserService userServiceMock;

	private UserDao userDaoMock = mock(UserDao.class);

	private MockMvc mockMvcUser;

	@BeforeEach
	public void setup() {
		this.mockMvcUser = MockMvcBuilders.standaloneSetup(new UserController()).build();
		userServiceMock = new UserService(userDaoMock);
	}

	@Test
	public void testUserHomePage() throws Exception {
		this.mockMvcUser.perform(get("/userHomePage")).andExpect(status().isOk()).andExpect(view().name("user"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}
	
	@Test
	public void testUserBuyerHomePage() throws Exception {
		this.mockMvcUser.perform(get("/buyer")).andExpect(status().isOk()).andExpect(view().name("buyerHomePage"))
				.andDo(MockMvcResultHandlers.print()).andReturn();
	}

	@Test
	public void testUserInsertIntoDb() throws Exception {
		User user = new User();
		user.setEmail("abc@gmail.com");
		user.setFirstName("Anmol");
		user.setLastName("Goyal");
		user.setGender("Female");
		user.setPassword("abc1@3");
		user.setPhoneNumber("9988776655");
		when(userDaoMock.insertIntoDb(user)).thenReturn(1);
		assertEquals(1, userServiceMock.insertIntoDb(user));
	}

	@Test
	public void testUserValidateCredentials() throws Exception {
		when(userDaoMock.validate("abc@gmail.com", "abc1@3")).thenReturn(1);
		assertEquals(true, userServiceMock.validateUser("abc@gmail.com", "abc1@3"));
	}
}
