package com.jaworskimateusz.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.jaworskimateusz.config.ApplicationConfig;
import com.jaworskimateusz.config.SecurityConfig;

import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration
@WebMvcTest(LoginController.class)
public class LoginControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void showLoginPage() throws Exception {
		mockMvc.perform(get("/login"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("login"));
	}
	
	@Test
	public void showHomePage() throws Exception {
		mockMvc.perform(get("/home"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("login"));
	}
	
	@Test
	public void showAccesDeniedPage() throws Exception {
		mockMvc.perform(get("/access-denied"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("access-denied"));
	}

}
