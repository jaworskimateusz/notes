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
import com.jaworskimateusz.service.NoteService;

import org.junit.runner.RunWith;
import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration
@WebMvcTest(NoteController.class)
public class NoteControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
    private NoteService noteService;
	
	@Test
	public void showFormForAdd() throws Exception {
		mockMvc.perform(get("/home/add-note"))    
	      .andExpect(status().isOk())  
	      .andExpect(view().name("update-note"))
	      .andExpect(model().attributeExists("note"));
	}
	
}
