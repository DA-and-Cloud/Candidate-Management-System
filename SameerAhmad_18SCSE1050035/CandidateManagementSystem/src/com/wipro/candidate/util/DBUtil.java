package com.wipro.candidate.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
public static Connection getDBConn() throws Exception {
	String url="jdbc:mysql://localhost:3306/JDBCProject";
	String uname="root";
	String pass="password";
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con=DriverManager.getConnection(url,uname,pass);
	return con;
}
}
