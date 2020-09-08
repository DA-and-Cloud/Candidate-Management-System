package com.wipro.candidate.bean;
public class CandidateBean {
    
    //private String id;
    private String name;
    private  int m1;
    private  int m2;
    private  int m3;
    private String result;
    private String grade;
    
    public void setName(String name){
        this.name=name;
    }
    public void setM1(int m1){
        this.m1=m1;
    }
    public void setM2(int m2){
        this.m2=m2;
    }
    public void setM3(int m3){
        this.m3=m3;
    }
    public void setResult(String result){
        this.result=result;
    }
    public void setGrade(String grade){
        this.grade=grade;
    }
    
    public String getName(){
        return this.name;
    }
    public int getM1(){
        return this.m1;
    }
    public int getM2(){
        return this.m2;
    }
    public int getM3(){
        return this.m3;
    }
    public String getResult(){
        return this.result;
    }
    public String getGrade(){
        return this.grade;
    }
    
    
    
}

























//Code By: Lakshya Bansal