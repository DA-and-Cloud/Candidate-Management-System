package com.wipro.candidate.service;

import java.util.ArrayList;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;
import com.wipro.candidate.util.WrongDataException;

public class CandidateMain {

	public String addCandidate(CandidateBean candBean) {
		String result="";
		String grade="";
		try{
            WrongDataException wde=new WrongDataException(candBean);
        }
		catch(Exception e){
            return "Data Incorrect";
        }
		int m1=candBean.getM1();
        int m2=candBean.getM2();
        int m3=candBean.getM3();
        if(m1+m2+m3>=240){
            result="PASS";
            grade="Distinction";
        }
        else if((m1+m2+m3)>=180&&(m1+m2+m3)<240){
            result="PASS";
            grade="First Class";
        }
        else if((m1+m2+m3)>=150&&(m1+m2+m3)<180){
            result="PASS";
            grade="Second Class";
        }
        else if((m1+m2+m3)>=105&&(m1+m2+m3)<150){
            result="PASS";
            grade="Third Class";
        }
        else if(m1+m2+m3<105){
            result="FAIL";
            grade="No Grade";
        }
        candBean.setResult(result);
        candBean.setGrade(grade);
        
        CandidateDAO obj=new CandidateDAO();
        String status=obj.addCandidate(candBean);
        
        if(status.equals("SUCCESS")){
            return candBean.getName()+" "+candBean.getResult();
        }
        return "Error";
		
	}
	
	 public ArrayList<CandidateBean> displayAll(String criteria){
	        if(criteria.equals("PASS")||criteria.equals("FAIL")||criteria.equals("ALL")){
	            CandidateDAO obj=new CandidateDAO();
	            return obj.getByResult(criteria);
	        }
	        else{
	            try{
	                WrongDataException wde=new WrongDataException();
	            }catch(Exception e){
	                System.out.println(e.getMessage());
	            }
	        }
	        return null;
	    }//end display
	
	
	
	public static void main(String[] args) {
		CandidateMain cmain=new CandidateMain();
		
		//Test Case 1:Null Value
		String res=cmain.addCandidate(null);
		System.out.println("Test Case: 1 \n"+res);
		
		//Test Case 2:Candidate Name to Be Empty
		CandidateBean cbeanobj=new CandidateBean();
		cbeanobj.setName("");//empty name
		cbeanobj.setM1(99);
		cbeanobj.setM2(89);
		cbeanobj.setM3(95);
		res= cmain.addCandidate(cbeanobj);
		System.out.println("Test Case: 2 \n"+res);

		//Test Case 3:Can name <2
		cbeanobj.setName("S");//name length less than 2
		cbeanobj.setM1(99);
		cbeanobj.setM2(89);
		cbeanobj.setM3(95);
		res= cmain.addCandidate(cbeanobj);
		System.out.println("Test Case: 3 \n"+res);
		
		//Test Case 4:Invalid Range of marks
		cbeanobj.setName("Sameer");
		cbeanobj.setM1(99);
		cbeanobj.setM2(420);//Exceeding range of 100
		cbeanobj.setM3(95);
		res= cmain.addCandidate(cbeanobj);
		System.out.println("Test Case: 4 \n"+res);
		
		//Test Case 5:Correct Candidate generation
		cbeanobj.setName("Sameer");
		cbeanobj.setM1(99);
		cbeanobj.setM2(90);//PASS CASE
		cbeanobj.setM3(95);
		res= cmain.addCandidate(cbeanobj);
		System.out.println("Test Case: 5 \n"+res);
		
		//Test Case 6:Checking correct computation of PASS FAIL and grade
		cbeanobj.setName("Ahmad");
		cbeanobj.setM1(9);
		cbeanobj.setM2(20);//FAIL CASE
		cbeanobj.setM3(35);
		res= cmain.addCandidate(cbeanobj);
		System.out.println("Test Case: 6 FAIL \n"+res);
		
		//Second Class
		cbeanobj.setName("Nadeem");
		cbeanobj.setM1(50);
		cbeanobj.setM2(50);
		cbeanobj.setM3(60);
		res= cmain.addCandidate(cbeanobj);
		System.out.println("Test Case: 6 2nd Grade \n"+res);
		
		ArrayList<CandidateBean> cands=new ArrayList<>();
		cands=cmain.displayAll("ALL");
		
		//Test Case 7:Null value generation for different criteria
        System.out.println("Test Case 7 "+cmain.displayAll("Bribed"));//no such criteria as Bribed
        
		//Test Case 8:Number of records Retrieved
        System.out.println("No of records Retrived: "+cands.size());
		
	}
}
