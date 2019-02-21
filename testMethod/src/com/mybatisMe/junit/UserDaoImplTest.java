package com.mybatisMe.junit;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.mybatisMe.Dao.UserDao;
import com.mybatisMe.common.CommonUtil;
import com.mybatisMe.entities.User;
import com.mybatisMe.service.UserService;

/*@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})*/
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
	@Test
	@DisplayName("spring with mybatis")
	void testSelectUserWithSpring() throws Exception {
	    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	    UserDao userDao = (UserDao)applicationContext.getBean("userDao");
		User user = userDao.selectUser(1);
		assertNotNull(user);
		assertEquals(33, user.getAge());
		assertEquals("john", user.getName());
	}
	@Test
	@DisplayName("select users")
	void testInsertUsers() throws Exception {
	    UserDao userDao = (UserDao)CommonUtil.getBean("userDao");
	    List<User> users = userDao.selectUsersByName("java");
	    assertNotNull(users);
	    assertEquals(5, users.size());
	}
	
	@Test
	@DisplayName("Update users")
	void testUpdatetUser() throws Exception {
		UserDao userDao = (UserDao)CommonUtil.getBean("userDao");
		User user = userDao.selectUser(10);
		user.setName("updateJava");
		userDao.updateUser(user);
		User user2 = userDao.selectUser(10);
		assertNotNull(user2);
		assertEquals("updateJava", user2.getName(),"update name");
	}
	
	@Test
	@DisplayName("delete users")
	void testDeleteUser() throws Exception{
		UserDao userDao = (UserDao)CommonUtil.getBean("userDao");
		userDao.deleteUser(10);
		User user = userDao.selectUser(10);
		assertNull(user);
	}

}
