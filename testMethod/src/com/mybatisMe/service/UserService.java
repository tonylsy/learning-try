package com.mybatisMe.service;

import java.util.List;

import com.mybatisMe.entities.User;

public interface UserService {
	
	User getUserById(int id);

	void createUser(User user);

	void createUsers(List<User> users);
}
