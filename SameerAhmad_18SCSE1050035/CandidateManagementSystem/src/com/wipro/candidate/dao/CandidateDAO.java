package com.wipro.candidate.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.util.DBUtil;

public class CandidateDAO {
	 static int CANDID_SEQ=5000;
	
	public String addCandidate(CandidateBean candidateBean) {
		//Query
		//prepared statement
		//pst set values
		//pst.executeUpdate()
		String query= "insert into CANDIDATE_TBL values(?,?,?,?,?,?)";
		PreparedStatement pst;
		try {
			pst=DBUtil.getDBConn().prepareStatement(query);
			
			pst.setString(1, candidateBean.getName());
			pst.setInt(2,candidateBean.getM1());
			pst.setInt(3,candidateBean.getM2());
			pst.setInt(4,candidateBean.getM3());
			pst.setString(5, candidateBean.getResult());
			pst.setString(6, candidateBean.getGrade());

			int flag=pst.executeUpdate();
			return (flag>0?"SUCCESS":"FAIL");
			
		}
		catch (Exception e) {
			System.out.println("FAIL");
			
		}
		return "FAIL";
	}// End AddCandidate
	
	public ArrayList<CandidateBean>getByResult(String criteria){
		String query="Select * from CANDIDATE_TBL where RESULT=";
		ArrayList<CandidateBean> candidates=new ArrayList<>(); 
		try {
			Statement st=DBUtil.getDBConn().createStatement();

		if(criteria.equals("PASS")) {
			ResultSet rs= st.executeQuery(query+criteria);
			while(rs.next()) {
				CandidateBean Canobj=new CandidateBean();
				
				Canobj.setId(rs.getString(1));
				Canobj.setName(rs.getString(2));
				Canobj.setM1(rs.getInt(3));
				Canobj.setM2(rs.getInt(4));
				Canobj.setM3(rs.getInt(5));
				Canobj.setResult(rs.getString(6));
				Canobj.setGrade(rs.getString(7));
				
				candidates.add(Canobj);
			}
			return candidates;
		}
		
		else if(criteria.equals("FAIL")) {
			
			ResultSet rs= st.executeQuery(query+criteria);
			while(rs.next()) {
				CandidateBean Canobj=new CandidateBean();
				
				Canobj.setId(rs.getString(1));
				Canobj.setName(rs.getString(2));
				Canobj.setM1(rs.getInt(3));
				Canobj.setM2(rs.getInt(4));
				Canobj.setM3(rs.getInt(5));
				Canobj.setResult(rs.getString(6));
				Canobj.setGrade(rs.getString(7));
				
				candidates.add(Canobj);
			}
			return candidates;
			
		}
		
		else if(criteria.equals("ALL")) {
			ResultSet rs= st.executeQuery("Select * from CANDIDATE_TBL");
			while(rs.next()) {
				CandidateBean Canobj=new CandidateBean();
				
				Canobj.setId(rs.getString(1));
				Canobj.setName(rs.getString(2));
				Canobj.setM1(rs.getInt(3));
				Canobj.setM2(rs.getInt(4));
				Canobj.setM3(rs.getInt(5));
				Canobj.setResult(rs.getString(6));
				Canobj.setGrade(rs.getString(7));
				
				candidates.add(Canobj);
			}
			return candidates;

		}
		
		else {
			return null;
		}
	 }//End Try
	 catch (Exception e) {
		return null;
	}//end catch
		
	}//end getByResult
	
	public String generateCandidateId(String name) {
		String genCanId="";
		name=name.toUpperCase();
		if(CANDID_SEQ<=7000) {
			genCanId=name.substring(0,2)+(CANDID_SEQ++);
			return genCanId;
		}
		return null;
		
	}//End gencanid
	
	
	

}// end class