package com.application.testapp.services;

import java.util.List;

import com.application.testapp.dao.UserDao;
import com.application.testapp.entities.User;

public class UserService {
	
	UserDao userDao = new UserDao();
	
	public void create(User user) {
		userDao.create(user);
		
	}

	public List<User> getUsers() {
		List<User> usersList = userDao.getUsers();
		return usersList;
	}

	public User loginUser(String email, String password) {
		User user = userDao.loginUser(email, password);
		return user;
	}

}
