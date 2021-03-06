package com.ignite.MyFirstIgniteJavaAppDemo;

import java.sql.*;

public class SelectTableDemo 
{
	public static void main(String[] args) throws ClassNotFoundException,SQLException 
	{
		// Register JDBC driver
		Class.forName("org.apache.ignite.IgniteJdbcThinDriver");

		// Open JDBC connection
		Connection conn = DriverManager.getConnection("jdbc:ignite:thin://192.168.1.6/");

		// Get data
		try (Statement stmt = conn.createStatement()) {
		    try (ResultSet rs =
		    stmt.executeQuery("SELECT p.name, c.name " +
		    " FROM Person p, City c " +
		    " WHERE p.city_id = c.id")) {

		      while (rs.next())
		         System.out.println(rs.getString(1) + ", " + rs.getString(2));
		    }
		}
	}
}
