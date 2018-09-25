package com.mybatisMe.service;

import java.util.List;

import com.mybatisMe.entities.User;

public interface UserService {
	/**
	 * 获取user表单挑内容
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User getUserById(int id) throws Exception;
	
	/**
	 * 创建单个用户
	 * @param user
	 * @throws Exception
	 */
	void createUser(User user) throws Exception;

	/**
	 * 创建多个用户
	 * @param users
	 * @throws Exception
	 */
	void createUsers(List<User> users) throws Exception;
}
