package com.cognizant;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.controller.AdminController;
import com.cognizant.controller.ManagerController;
import com.cognizant.controller.UserController;
import com.cognizant.controller.WelcomeController;

public class ControllerTest {

    private MockMvc mockMvcWelcome;
    private MockMvc mockMvcUser;
    private MockMvc mockMvcAdmin;
    private MockMvc mockMvcManager;

    @BeforeEach
    public void setup() {
        this.mockMvcUser = MockMvcBuilders.standaloneSetup(new UserController()).build();
        this.mockMvcAdmin = MockMvcBuilders.standaloneSetup(new AdminController()).build();
        this.mockMvcWelcome = MockMvcBuilders.standaloneSetup(new WelcomeController()).build();
        this.mockMvcManager = MockMvcBuilders.standaloneSetup(new ManagerController()).build();
    }
    
    @Test
    public void testAppHomePage() throws Exception {
        this.mockMvcWelcome.perform(get("/recycleManagementHomePage"))
                .andExpect(status().isOk())
                .andExpect(view().name("homePage"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    } 
    
    @Test
    public void testUserHomePage() throws Exception {
        this.mockMvcUser.perform(get("/userHomePage"))
                .andExpect(status().isOk())
                .andExpect(view().name("user"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    
    @Test
    public void testAdminHomePage() throws Exception {
        this.mockMvcAdmin.perform(get("/adminHomePage"))
                .andExpect(status().isOk())
                .andExpect(view().name("loginAdmin"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    
    @Test
    public void testManagerHomePage() throws Exception {
        this.mockMvcManager.perform(get("/manager"))
                .andExpect(status().isOk())
                .andExpect(view().name("managerLoginReg"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
    
}

