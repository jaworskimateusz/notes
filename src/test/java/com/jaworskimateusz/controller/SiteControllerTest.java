package com.jaworskimateusz.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

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
@WebMvcTest(SiteController.class)
public class SiteControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testIndexPage() throws Exception {
		mockMvc.perform(get("/index"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("index"));
	}
	
	@Test
	public void testAboutPage() throws Exception {
		mockMvc.perform(get("/about"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("about"));
	}
	
	@Test
	public void testHomePage() throws Exception {
		mockMvc.perform(get(""))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("index"));
	}
	

}
