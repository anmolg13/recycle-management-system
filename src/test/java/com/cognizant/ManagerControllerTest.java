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

import com.cognizant.controller.ManagerController;
import com.cognizant.dao.ManagerDao;
import com.cognizant.service.ManagerService;

public class ManagerControllerTest {

	private ManagerService managerServiceMock;

	private ManagerDao managerDaoMock = mock(ManagerDao.class);
	
	private MockMvc mockMvcManager;

	@BeforeEach
	public void setup() {
		this.mockMvcManager = MockMvcBuilders.standaloneSetup(new ManagerController()).build();
		managerServiceMock = new ManagerService(managerDaoMock);
	}
	
	@Test
    public void testManagerCheckManagerCredentials() throws Exception{
    	when(managerDaoMock.checkManagerCredentials("abc@gmail.com","123abc")).thenReturn(true);
    	assertEquals(managerServiceMock.checkManagerCredentials("abc@gmail.com", "123abc"),true);
    }
	
	@Test
	public void testManagerHomePage() throws Exception {
		this.mockMvcManager.perform(get("/manager")).andExpect(status().isOk())
				.andExpect(view().name("managerLoginReg")).andDo(MockMvcResultHandlers.print()).andReturn();
	}

}
