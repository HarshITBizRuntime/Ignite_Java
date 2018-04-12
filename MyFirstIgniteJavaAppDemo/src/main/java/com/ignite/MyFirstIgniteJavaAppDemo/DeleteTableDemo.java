package com.ignite.MyFirstIgniteJavaAppDemo;

import java.sql.*;

public class DeleteTableDemo 
{
	public static void main(String[] args) throws ClassNotFoundException,SQLException 
	{
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.28/");
		try (Statement stmt = conn.createStatement()) {
			stmt.executeUpdate("Drop TABLE City"); 
			stmt.executeUpdate("Drop TABLE Person");
		
		}
	System.out.println("Tables deleted");
	}
}
