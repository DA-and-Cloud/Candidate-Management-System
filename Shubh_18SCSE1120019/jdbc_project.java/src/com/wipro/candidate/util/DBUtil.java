package com.wipro.candidate.util;

import java.sql.*;
public class DBUtil {
	
	public static Connection getDbConn(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			Connection con = DriverManager.getConnection( "jdbc:mysql://localhost:3306/cms", "root", "2521070");
			System.out.println("Success");
			return con;
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
