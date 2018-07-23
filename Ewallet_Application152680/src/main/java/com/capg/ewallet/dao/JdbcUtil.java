package com.capg.ewallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcUtil {
public static Connection  getConnection() {
	
	
	Connection conn=null;
	
	try
	{
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
		
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ewallet_application","root","Capgemini@123");
		
	}catch (Exception e) {
		// TODO: handle exception
		
		e.printStackTrace();
		
	}
	
	return conn;
	
	
}
	
	
	
	
}