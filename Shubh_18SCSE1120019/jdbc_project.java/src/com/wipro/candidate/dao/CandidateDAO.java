package com.wipro.candidate.dao;
import com.wipro.candidate.bean.*;
import com.wipro.candidate.util.*;
import java.sql.*;
import java.util.*;

public class CandidateDAO {
	public String addCandidate(CandidateBean CandidateBean) {
		Connection con = DBUtil.getDbConn(); 
		try {
			PreparedStatement ps = con.prepareStatement("insert into candidate_tbl3(NAME,M1,M2,M3,RESULT,GRADE) values(?,?,?,?,?,?)");
			//ps.setString(1, CandidateBean.getId());
			ps.setString(2, CandidateBean.getName());
			ps.setInt(3, CandidateBean.getM1());
			ps.setInt(4, CandidateBean.getM2());
			ps.setInt(5, CandidateBean.getM3());
			ps.setString(6, CandidateBean.getResult());
			ps.setString(7, CandidateBean.getGrade());
			if(ps.execute())
				return "SUCCESS";
			else	
				return "FAIL";
		}
		catch(SQLException e) {
			return "FAIL";
		}	
	}
	
	public ArrayList<CandidateBean> getByResult(String criteria){
		Connection con = DBUtil.getDbConn();
		ResultSet rs = null;
		ArrayList<CandidateBean> res = new ArrayList<CandidateBean>();
		
		try{
			if(criteria.equals("ALL")){
				Statement stmt = (Statement)con.createStatement();
				rs = stmt.executeQuery("SELECT*FROM CANDIDATE_TBL");
			}
			
			else{
				PreparedStatement ps = con.prepareStatement("select * from candidate_tbl where result=?");
				ps.setString(1, criteria);
				rs = ps.executeQuery();
			}

			while(rs.next()){
				CandidateBean CandidateBean = new CandidateBean();
				//CandidateBean.setId(rs.getString(1));
				CandidateBean.setName(rs.getString(2));
				CandidateBean.setM1(rs.getInt(3));
				CandidateBean.setM2(rs.getInt(4));
				CandidateBean.setM3(rs.getInt(5));
				CandidateBean.setResult(rs.getString(6));
				CandidateBean.setGrade(rs.getString(7));
				res.add(CandidateBean);
			}
			
			if(res.isEmpty())
				return null;
			
			else
				return res;
			
		}
		catch(SQLException e){
			System.out.println(e);
		}
		
		return res;
	}
	
}
