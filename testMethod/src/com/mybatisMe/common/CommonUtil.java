package com.mybatisMe.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CommonUtil{
	public static SqlSessionFactory getSqlFactory() throws IOException {
		InputStream inputSream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputSream);
		return sqlSessionFactory;
	}
}
