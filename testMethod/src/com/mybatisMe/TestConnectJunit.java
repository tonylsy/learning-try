package com.mybatisMe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TestConnectJunit {
	private String driver;
	private String url;
	private String user;
	private String password;
	private static TestConnect testConnect = new TestConnect();

	
	/*
	public TestConnectJunit(String driver, String url, String user, String password) {
		this.driver = driver;
		this.url = url;
		this.user = user;
		this.password = password;
	}*/

	@Test
	void testOriginalJdbcTest() throws ClassNotFoundException, SQLException {
		testConnect.originalJdbcTest();
	}

	@Test
	void testPropertiesJdbcTest() throws ClassNotFoundException, IOException, SQLException {
		testConnect.propertiesJdbcTest();
	}

	@ParameterizedTest
	@MethodSource("paramData")
	void testRunJdbc(String driver, String url, String user, String password)
			throws ClassNotFoundException, SQLException {
		System.out.println(driver + ">>>>>" + url + ">>>>>" + user + ">>>>>" + password);
		testConnect.runJdbc(driver, url, user, password);
	}
	static Collection paramData() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/hello?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2b8";
		String user = "root";
		String password = "123456";

		//Object[][] objectArr = { { driver, url, user, password }, { driver + "y", url + "y", user, password } };
		//System.out.println(objectArr);
		Object [][] objectArr = {{driver,url,user,password}};
		return Arrays.asList(objectArr);
	}
	/*static Stream<Arguments> stringIntAndListProvider() {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://127.0.0.1:3306/hello?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2b8";
		String user = "root";
		String password = "123456";
		Stream<Arguments> rs = 
		 Stream.of(
	        Arguments.of(driver,url,user,password)
	    );
		return rs;
	}*/

	@ParameterizedTest
	@MethodSource("stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list) {
	    assertEquals(3, str.length());
	    assertTrue(num >=1 && num <=2);
	    assertEquals(2, list.size());
	}

	static Stream<Arguments> stringIntAndListProvider() {
	    return Stream.of(
	    		Arguments.of("foo", 1, Arrays.asList("a", "b")),
	    		Arguments.of("bar", 2, Arrays.asList("x", "y"))
	    );
	}
	
}
