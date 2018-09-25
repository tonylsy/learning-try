package com.mybatisMe.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mybatisMe.Dao.UserDao;
import com.mybatisMe.entities.User;
import com.mybatisMe.service.UserService;

@Service("userService")
public class UserSeriveImpl implements UserService {
	@Autowired
	UserDao userDao;
	
	@Override
	public User getUserById(int id) throws Exception {
		// TODO Auto-generated method stub
		User user = userDao.selectUser(id);
		return user;
	}

	@Override
	public void createUser(User user) throws Exception {
		// TODO Auto-generated method stub
		userDao.insertUser(user);
	}

	@Override
	@Transactional
	public void createUsers(List<User> users) throws Exception {
		// TODO Auto-generated method stub
		userDao.insertUsers(users);
	}

}
