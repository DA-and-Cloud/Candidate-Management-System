package com.wipro.candidate.bean;

public class CandidateBean {
	
	private String name;
	private  int M1;
	private  int M2;
	private  int M3;
	private String result;
	private String grade;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getM1() {
		return M1;
	}
	public void setM1(int m1) {
		M1 = m1;
	}
	public int getM2() {
		return M2;
	}
	public void setM2(int m2) {
		M2 = m2;
	}
	public int getM3() {
		return M3;
	}
	public void setM3(int m3) {
		M3 = m3;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}

}
