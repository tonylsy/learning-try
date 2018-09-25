package com.mybatisMe.common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommonUtil{
	public static SqlSessionFactory getSqlFactory() throws IOException {
		InputStream inputSream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputSream);
		return sqlSessionFactory;
	}
	
	public static Object getBean(String beanname){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		return ctx.getBean(beanname);
	}
	
	public static Object getBean(Class clazz) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		return ctx.getBean(clazz);
	}
}
