package com.jaworskimateusz.service;

import com.jaworskimateusz.entity.User;

public interface UserService {
	
	public void save(User user);
		
	public User findByEmail(String email);
	
}
