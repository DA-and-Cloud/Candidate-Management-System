
package com.wipro.candidate.util;
import com.wipro.candidate.bean.CandidateBean;
public class WrongDataException {
    public WrongDataException(CandidateBean cb) throws Exception{
        if(cb==null){
            throw new Exception("");
        }
        else if(cb.getName().equals("")){
            throw new Exception("");
        }
        else if(cb.getName().length()<2){
            //System.out.println("Lakshya");
            throw new Exception("");
        }
        else if((cb.getM1()>100||cb.getM1()<0)||(cb.getM2()>100||cb.getM2()<0)||(cb.getM3()>100||cb.getM3()<0)){
            throw new Exception("");
        }
    }
    
    public WrongDataException() throws Exception{
        throw new Exception("");
    }
}


