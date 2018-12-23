package com.jaworskimateusz.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.jaworskimateusz.entity.User;
import com.jaworskimateusz.validation.NewUser;

public interface UserService extends UserDetailsService {
	
	public void save(NewUser newUser);
		
	public User findByEmail(String email);
	
}
