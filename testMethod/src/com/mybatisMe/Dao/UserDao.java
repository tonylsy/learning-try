package com.mybatisMe.Dao;

import java.util.List;

import com.mybatisMe.entities.User;

public interface UserDao {
	/**
	 * 查询
	 * @param id
	 * @return
	 * @throws Exception 
	 */
	public User selectUser(int id) throws Exception;
	
	/**
	 * 新增
	 * @param user
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * 批量新增
	 * @param users
	 */
	public void insertUsers(List<User> users) throws Exception;
}
