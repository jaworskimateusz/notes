package com.jaworskimateusz.dao;

import com.jaworskimateusz.entity.User;

public interface UserDao {
	
	public void save(User user);
	
	public User findByName(String name);

}
