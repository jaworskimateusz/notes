package com.jaworskimateusz.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.jaworskimateusz.config.ApplicationConfig;
import com.jaworskimateusz.config.SecurityConfig;
import com.jaworskimateusz.service.UserService;

import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private UserService userService;
	
	@Test
	public void testRegistrationPage() throws Exception {
		mockMvc.perform(get("/registration"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("registration"))
	      .andExpect(model().attributeExists("newUser"));
	}
	
	@Test
	public void testProcessRegistration() throws Exception {
		mockMvc.perform(post("/process-registration")
				.with(csrf())
	            .param("action", "signup")) 
	      .andExpect(status().isOk())  
	      .andExpect(view().name("login"));
	}

}
