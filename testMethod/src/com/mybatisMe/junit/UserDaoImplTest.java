package com.mybatisMe.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatisMe.Dao.UserDao;
import com.mybatisMe.Dao.Impl.UserDaoImpl;
import com.mybatisMe.common.CommonUtil;
import com.mybatisMe.entities.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
class UserDaoImplTest {

	/*@Autowired
	private UserDao userdao;*/
	
	@Test
	void testSelectuser() throws Exception {
		SqlSessionFactory sqlSessionFactory = CommonUtil.getSqlFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = userDao.selectUser(1);
		assertNotNull(user);
		assertEquals(33, user.getAge());
		assertEquals("john", user.getName());
	}
	/*@Test
	void testInsertUser() {
		//User user = userService.getUserById(0);
		
	}
	@Test
	void testInsertUsers() {
		//User user = userService.getUserById(0);
		
	}*/

}
