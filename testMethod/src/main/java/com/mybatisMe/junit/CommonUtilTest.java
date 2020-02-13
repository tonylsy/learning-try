package com.mybatisMe.junit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mybatisMe.Dao.UserDao;
import com.mybatisMe.common.CommonUtil;
import com.mybatisMe.entities.User;

class CommonUtilTest {

	@Test
	void testGetBeanByClass() throws Exception {
		UserDao userDao =(UserDao)CommonUtil.getBean(UserDao.class);
		User user = userDao.selectUser(1);
		assertNotNull(user);
		assertEquals(33, user.getAge());
		assertEquals("john", user.getName());
	}
	@Test
	void testGetBeanByName() throws Exception {
		UserDao userDao =(UserDao)CommonUtil.getBean("userDao");
		User user = userDao.selectUser(1);
		assertNotNull(user);
		assertEquals(33, user.getAge());
		assertEquals("john", user.getName());
	}

}
