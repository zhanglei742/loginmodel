package com.loginmodel.loginmodel.service;
//修改密码接口
public interface ChangePasswordServlet {
    //忘记密码，输入新密码、确认新密码
    public boolean ForgetPassword(String phonenumber, String newpassword);
}
