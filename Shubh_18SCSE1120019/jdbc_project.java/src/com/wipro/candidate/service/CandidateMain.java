package com.wipro.candidate.service;
import java.util.ArrayList;
import java.util.Iterator;
import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.dao.CandidateDAO;
import com.wipro.candidate.util.WrongDataException;

public class CandidateMain {
	public static void main(String[] args) throws WrongDataException{
		CandidateMain candidateMain = new CandidateMain();
		CandidateBean cb = new CandidateBean();
		CandidateDAO dao = new CandidateDAO();
		
		try {
		//Test-1
		String result = candidateMain.addCandidate(null);
		System.out.println("Test1 : "+ result);
		
		//Test-2
		cb.setName("");
		cb.setM1(90);
        cb.setM2(90);
        cb.setM3(90);
        result = candidateMain.addCandidate(cb);
        System.out.println("Test2 : "+ result);
        
        //Test-3
        cb.setName("a");
        cb.setM1(90);
        cb.setM2(90);
        cb.setM3(90);
        result = candidateMain.addCandidate(cb);
        System.out.println("Test3 : "+result);
		
        //Test-4
        cb.setName("Shubh");
        cb.setM1(200);
        cb.setM2(30);
        cb.setM3(90);
        result = candidateMain.addCandidate(cb);
        System.out.println("Test4 : "+result);
        
        cb.setName("Shubh");
        cb.setM1(90);
        cb.setM2(90);
        cb.setM3(90);
        result = dao.addCandidate(cb);
        //System.out.println("1. "+result);
        
        cb.setName("John");
        cb.setM1(20);
        cb.setM2(30);
        cb.setM3(10);
        result = dao.addCandidate(cb);
       // System.out.println("2. "+result);
        
        cb.setName("Harry");
        cb.setM1(45);
        cb.setM2(40);
        cb.setM3(60);
        result = dao.addCandidate(cb);
        //System.out.println("3. "+result);
       
        System.out.println(dao.getByResult("ALL"));
        
        //Test-6
        Iterator<CandidateBean> itr = candidateMain.displayAll("FAIL").iterator();
        System.out.print("Test6 :\n");
        while(itr.hasNext()){
            System.out.print(itr.next()+" ");
        }
        System.out.print("\n");
        
        //Test-8
        Iterator<CandidateBean> it = candidateMain.displayAll("ALL").iterator();
        int count=0;
        while(it.hasNext()){
            count++;
            it.next();
        }
        System.out.println("Test8 : "+count);
		} 
        catch(NullPointerException e) {
        	System.out.print("Test6 and Test8 : "+e);
        }
        //Test-7
        System.out.println("Test7 : "+candidateMain.displayAll("ALL"));
        
	}
	
	public String addCandidate(CandidateBean candBean) throws WrongDataException{
		try{
			if(candBean==null||candBean.getName()==""||candBean.getName().length()<2||candBean.getM1()<0||candBean.getM1()>100||candBean.getM2()<0||candBean.getM2()>100||candBean.getM3()<0||candBean.getM3()>100){
			throw new WrongDataException();
			}
		}
		catch(WrongDataException e) {
			return "DATA INCORRECT";
		}
		
		int total = candBean.getM1()+candBean.getM1()+candBean.getM3();
		if(total>=240){
			candBean.setResult("PASS");
			candBean.setGrade("DISTINCTION");
		}
		else if(total>=180 && total<240){
			candBean.setGrade("FIRST CLASS");
			candBean.setResult("PASS");
		}
		else if(total>=150 && total<180){
			candBean.setGrade("SECOND CLASS");
			candBean.setResult("PASS");
		}
		else if(total>=105 && total<150){
			candBean.setGrade("THIRD CLASS");
			candBean.setResult("PASS");
		}
		else{
			candBean.setGrade("NO GRADE");
			candBean.setResult("FAIL");
		}
		
		CandidateDAO dao = new CandidateDAO();
		dao.addCandidate(candBean);
		String result;
		if(total>=105)
			result = "PASS";
		else
			result = "FAIL";
		return candBean.getName()+":"+result;
		
	}
	
	public ArrayList<CandidateBean> displayAll(String criteria){
		
		ArrayList<CandidateBean> res = new ArrayList<CandidateBean>();
		
		if(criteria.equals("PASS")||criteria.equals("FAIL")||criteria.equals("ALL")){
			CandidateDAO dao = new CandidateDAO();
			res = dao.getByResult(criteria);
		}
		
		else {
			try{ throw new WrongDataException(); }
			catch(WrongDataException e){ return null; }
		}
		
		return res;
	}

}
