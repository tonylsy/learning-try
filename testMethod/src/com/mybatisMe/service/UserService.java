package com.mybatisMe.service;

import java.util.List;

import com.mybatisMe.entities.User;

public interface UserService {
	/**
	 * ��ȡuser��������
	 * @param id
	 * @return
	 * @throws Exception
	 */
	User getUserById(int id) throws Exception;
	
	/**
	 * ���������û�
	 * @param user
	 * @throws Exception
	 */
	void createUser(User user) throws Exception;

	/**
	 * ��������û�
	 * @param users
	 * @throws Exception
	 */
	void createUsers(List<User> users) throws Exception;
}
