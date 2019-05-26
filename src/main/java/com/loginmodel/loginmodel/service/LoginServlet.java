package com.loginmodel.loginmodel.service;
import  com.loginmodel.loginmodel.domain.*;
public interface LoginServlet {
	//public  void  InputInfo(String number,String password);
	public boolean InsertInfoToDB(String number, String password);
	public boolean MatchInfo(String number, String password);
	//public  boolean UpdateName(String phone, String name);
	//mybatis新增内容
	public boolean PhoneExist(long phone);
	public String AddUser(long phone, String pwd);
	public boolean UpdateUserInfo(long phone, User user);
	public User LoginByPwd(long phone);
}
