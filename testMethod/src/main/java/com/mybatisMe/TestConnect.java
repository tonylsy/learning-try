package com.mybatisMe;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestConnect {
	private String driver = null;
	private String url = null;
	private String user = null;
	private String password = null;

	public void originalJdbcTest() throws ClassNotFoundException, SQLException {
		driver = "com.mysql.jdbc.Driver";
		url = "jdbc:mysql://127.0.0.1:3306/hello?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2b8";
		user = "root";
		password = "123456";
		runJdbc(driver, url, user, password);
	}

	public void propertiesJdbcTest() throws IOException, ClassNotFoundException, SQLException {
		InputStream in = this.getClass().getResourceAsStream("/database.properties");
		InputStreamReader inputStreamReader = new InputStreamReader(in, "UTF-8");
		Properties property = new Properties();
		property.load(inputStreamReader);
		String propertyHeader = "mysql.";
		driver = property.getProperty(propertyHeader + "driver");
		url=property.getProperty(propertyHeader + "url");
		user=property.getProperty(propertyHeader + "username"); 
		password=property.getProperty(propertyHeader + "password");
		runJdbc(driver, url, user, password);

	}

	public void runJdbc(String driver, String url, String user, String password)
			throws ClassNotFoundException, SQLException {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, user, password);
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from user");
	}
}
