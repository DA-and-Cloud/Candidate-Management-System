package com.wipro.candidate.util;

import com.wipro.candidate.bean.CandidateBean;

public class WrongDataException {
    public WrongDataException(CandidateBean candiBean) throws Exception{
        if(candiBean==null){
            throw new Exception("");
        }
        else if(candiBean.getName().equals("")){
            throw new Exception("");
        }
        else if(candiBean.getName().length()<2){
            throw new Exception("");
        }
        else if((candiBean.getM1()>100||candiBean.getM1()<0)||(candiBean.getM2()>100||candiBean.getM2()<0)||(candiBean.getM3()>100||candiBean.getM3()<0)){
            throw new Exception("");
        }
    }
    
    public WrongDataException() throws Exception{
        throw new Exception("");
    }
}


