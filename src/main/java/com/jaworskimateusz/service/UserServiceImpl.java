package com.jaworskimateusz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jaworskimateusz.dao.UserDao;
import com.jaworskimateusz.entity.User;
import com.jaworskimateusz.validation.NewUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	@Transactional
	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	@Transactional
	public void save(NewUser newUser) {
		User user = new User();
		setUserProperties(user, newUser);
		userDao.save(user);
	}

	private void setUserProperties(User user, NewUser newUser) {
		user.setName(newUser.getName());
		user.setEmail(newUser.getEmail());
		user.setPassword(newUser.getPassword());
	}

}
