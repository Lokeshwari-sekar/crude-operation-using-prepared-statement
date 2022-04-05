package com.studentpreparedst;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbconnectClass
{
	static String driver="com.mysql.cj.jdbc.Driver";
	static String url="jdbc:mysql://localhost:3306/edustudent";
	static String un="root";
	static String pa="root";
	static Connection conn=null;
	public static Connection getConnection()
	{
		
		try
		{
			Class.forName(driver);
			conn=DriverManager.getConnection(url, un, pa);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return conn;
		
	}
	

}
