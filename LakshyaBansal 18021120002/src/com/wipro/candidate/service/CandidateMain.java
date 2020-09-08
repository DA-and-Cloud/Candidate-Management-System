package com.wipro.candidate.service;
import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.util.WrongDataException;
import com.wipro.candidate.dao.CandidateDAO;
import java.util.*;
public class CandidateMain {
    public String addCandidate(CandidateBean cb){
//        String name;
//        int m1;
//        int m2;
//        int m3;
        String result="";
        String grade="";
        try{
            WrongDataException wde=new WrongDataException(cb);
        }catch(Exception e){
            //System.out.println(e.getMessage());
            return "Data Incorrect";
        }
        int m1=cb.getM1();
        int m2=cb.getM2();
        int m3=cb.getM3();
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
        cb.setResult(result);
        cb.setGrade(grade);
        CandidateDAO obj=new CandidateDAO();
        String status=obj.addCandidate(cb);
        if(status.equals("SUCCESS")){
            return cb.getName()+" "+cb.getResult();
        }
        return "Error";
    }
    
    public ArrayList<CandidateBean> diaplayAll(String criteria){
        //ArrayList<CandidateBean> al=new ArrayList<CandidateBean>();
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
    }
    
    
    public static void main(String args[]){
        CandidateMain cm=new CandidateMain();
        //Test Case 1
        String result=cm.addCandidate(null);
        System.out.println("Test case 1 "+result);
        //Test case 2
        CandidateBean cb=new CandidateBean();
        cb.setName("");
        cb.setM1(90);
        cb.setM2(90);
        cb.setM3(90);
        result=cm.addCandidate(cb);
        System.out.println("Test case 2 "+result);
        //Test Case 3
        cb.setName("L");
        cb.setM1(90);
        cb.setM2(90);
        cb.setM3(90);
        result=cm.addCandidate(cb);
        System.out.println("Test case 3 "+result);
        //Test Case 4
        cb.setName("Lakshya");
        cb.setM1(190);
        cb.setM2(90);
        cb.setM3(90);
        result=cm.addCandidate(cb);
        System.out.println("Test case 4 "+result);
        //Test Case 6
        Iterator it=cm.diaplayAll("ALL").iterator();
        System.out.print("Test Case 6 ");
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.print("\n");
        //Test Case 7
        System.out.println("Test Case 7 "+cm.diaplayAll("Topper"));
        //Test Case 8
        Iterator it3=cm.diaplayAll("ALL").iterator();
        int count=0;
        while(it3.hasNext()){
            count++;
            it3.next();
        }
        System.out.println("Test Case 8 "+count);

        System.out.println("Project By: Lakshya Bansal");
    }
}
