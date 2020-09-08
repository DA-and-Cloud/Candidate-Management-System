package com.wipro.candidate.util;
import java.sql.*;

public class DBUtil {

    public static Connection getDBConn(){
        Connection cn=null;
        try{
            cn=DriverManager.getConnection("jdbc:mysql://localhost/CMS","root","");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return cn;
    }
}
