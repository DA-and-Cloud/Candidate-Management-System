package com.wipro.candidate.util;

import java.sql.*;


public class CreateTable {

	public static void main(String[] args) {
		
		Connection conn = DBUtil.getDbConn();
	    Statement stmt = null;
		
		try {
			stmt = conn.createStatement();
			String sql = "CREATE TABLE CANDIDATE_TBL"
					+ "(ID INT(10) not null,"
					+ "name TEXT(20),"
					+ "M1 number(3),"
					+ "M2 number(3),"
					+ "M3 number(3),"
					+ "result TEXT(15),"
					+ "grade TEXT(15))";
			stmt.executeUpdate("CREATE SEQUENCE candidate_SEQ START WITH 5000 MINVALUE 5000 MAXVALUE 7000 INCREMENT BY 1");
			stmt.executeUpdate(sql);
			stmt.close();
			
			System.out.println("Table created successfully");
			
		} catch ( Exception e ) {
	         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
	         System.exit(0);
	      }
		
	}

}
