package com.jaworskimateusz.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jaworskimateusz.config.ApplicationConfig;
import com.jaworskimateusz.config.SecurityConfig;
import com.jaworskimateusz.dao.UserDao;
import com.jaworskimateusz.entity.User;
import com.jaworskimateusz.service.UserService;
import com.jaworskimateusz.service.UserServiceImpl;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.junit.Test;

/**
 * @author jaworskimateusz
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class, SecurityConfig.class})
@WebAppConfiguration
@WebMvcTest(UserService.class)
public class UserServiceTest {

	@InjectMocks
	private UserServiceImpl userService;
	
	@Mock
	private UserDao userDao;
	
	@Test
	public void findByName_userFound() {
		User user = new User("Joe");
		when(userDao.findByName("Joe")).thenReturn(user);
		assertEquals(user, userService.findByName("Joe"));
		verify(userDao, times(1)).findByName("Joe");
	}
	
	@Test
	public void findByName_userNotFound() {
		when(userDao.findByName("")).thenReturn(null);
		assertNull(userService.findByName(""));
	}
	
	@Test
	public void loadUserByUsername_UsernameNotFoundException() {
		when(userDao.findByName("")).thenThrow(UsernameNotFoundException.class);
		assertThrows(UsernameNotFoundException.class,() -> {
			userDao.findByName("");
		});
		
		verify(userDao, times(1)).findByName("");
	}
	
}
