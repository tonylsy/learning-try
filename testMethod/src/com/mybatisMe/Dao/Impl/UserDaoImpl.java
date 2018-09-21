package com.mybatisMe.Dao.Impl;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.mybatisMe.Dao.UserDao;
import com.mybatisMe.common.CommonUtil;
import com.mybatisMe.entities.User;
/**
 * this implement is used in no spring project
 * in spring project, we can build a bean in the applicationContext.xml and use @Autowired to implement interface
 * @author lisiyuan
 *
 */
@Service
public class UserDaoImpl implements UserDao{
	private SqlSession sqlSession;
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			sqlSessionFactory = CommonUtil.getSqlFactory();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public User selectUser(int id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession = sqlSessionFactory.openSession();
		UserDao userDao = sqlSession.getMapper(UserDao.class);
		User user = userDao.selectUser(id);
		releaseSource(sqlSession,"select",true);
		return user;
	}

	@Override
	public void insertUser(User user) throws Exception{
		// TODO Auto-generated method stub
		sqlSession = sqlSessionFactory.openSession();
		releaseSource(sqlSession,"insert",true);
	}

	@Override
	public void insertUsers(List<User> users) throws Exception {
		// TODO Auto-generated method stub
		sqlSession = sqlSessionFactory.openSession();
		releaseSource(sqlSession,"insert",true); 
	}
	
	private void releaseSource(SqlSession sqlSession,String operation,boolean iscommit) {
		if(!"select".equals(operation)) {
			sqlSession.commit(iscommit);
		}
		sqlSession.close();
	}

}
