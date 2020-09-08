package com.wipro.candidate.dao;
import com.wipro.candidate.util.DBUtil;
import com.wipro.candidate.bean.CandidateBean;
import java.sql.*;
import java.util.*;

public class CandidateDAO {
    Connection cn=null;
    Statement stmt=null;
    ResultSet rs=null;
    public CandidateDAO(){
        cn=DBUtil.getDBConn();
    }
    public String addCandidate(CandidateBean  cb){
        String status="";
        try{
            
            String sql="Insert into Candidate_TBL(NAME,M1,M2,M3,RESULT,GRADE) values(?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(sql);
            ps.setString(1,cb.getName());
            ps.setInt(2,cb.getM1());
            ps.setInt(3,cb.getM2());
            ps.setInt(4,cb.getM3());
            ps.setString(5,cb.getResult());
            ps.setString(6,cb.getGrade());
            int res=ps.executeUpdate();
            if(res>0){
                status="SUCCESS";
            }
            else{
                status="FAIL";
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            status="FAIL";
        }
        
        
        return status;
    }
    
    public ArrayList<CandidateBean> getByResult(String criteria){
        ArrayList<CandidateBean> list=new ArrayList<CandidateBean>();
        try{
        stmt=(Statement) cn.createStatement();
        if(criteria.equals("ALL")){
            rs=stmt.executeQuery("SELECT*FROM CANDIDATE_TBL");
        }
        else{
            rs=stmt.executeQuery("SELECT*FROM CANDIDATE_TBL WHERE RESULT='"+criteria+"'");
        }
        while(rs.next()){
            CandidateBean obj=new CandidateBean();
            obj.setName(rs.getString("Name"));
            obj.setM1(rs.getInt("M1"));
            obj.setM2(rs.getInt("M2"));
            obj.setM3(rs.getInt("M3"));
            obj.setResult(rs.getString("RESULT"));
            obj.setGrade(rs.getString("GRADE"));
            list.add(obj);
        }
        if(list.isEmpty()){
            list=null;
        }
        }catch(SQLException e){
            System.out.println(e.getMessage());
            list=null;
        }
        return list;
    }
}




//Code By: Lakshya Bansal