package com.wipro.candidate.util;

import java.sql.*;


public class DBUtil {
	public static Connection getDbConn(){
		Connection conn = null;
	      try {
	         Class.forName("org.postgresql.Driver");
	         conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/shash", "postgres", "1king@");
	         System.out.println("Opened database successfully");
	         return conn;
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
		return conn;
	}
}
