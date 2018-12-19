package com.jaworskimateusz.dao;

import com.jaworskimateusz.entity.User;

public interface UserDAO {
	
	public void save(User user);
	
	public User findByEmail(String email);

}
