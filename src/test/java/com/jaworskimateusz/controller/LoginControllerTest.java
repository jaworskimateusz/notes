package com.jaworskimateusz.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.jaworskimateusz.config.ApplicationConfig;
import com.jaworskimateusz.config.SecurityConfig;
import com.jaworskimateusz.service.UserService;

import org.junit.runner.RunWith;
import org.hamcrest.Matchers;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private UserService userService;
	
	@Test
	public void testLoginPage() throws Exception {
		mockMvc.perform(get("/login"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("login"));
	}
	
	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(get("/home"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("login"));
	}
	
	@Test
	public void testAccesDeniedPage() throws Exception {
		mockMvc.perform(get("/access-denied"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("access-denied"));
	}
	

}
