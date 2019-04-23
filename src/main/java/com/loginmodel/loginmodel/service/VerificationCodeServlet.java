package com.loginmodel.loginmodel.service;
//import redistools.*;
public interface VerificationCodeServlet {
    //接受手机号
    public boolean SendCode(String phone, String location);

    //匹配手机号、验证码
    public boolean CheckCode(String phone, String location, String code);

}

