package com.mybatisMe.Dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mybatisMe.entities.User;
@Repository
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
	public void insertUsers(@Param("users") List<User> users) throws Exception;
}
