package com.jaworskimateusz.service;

import com.jaworskimateusz.entity.User;
import com.jaworskimateusz.validation.NewUser;

public interface UserService {
	
	public void save(NewUser newUser);
		
	public User findByEmail(String email);
	
}
