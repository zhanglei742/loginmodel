package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.*;
import com.loginmodel.loginmodel.util.BaseInitDBhelper;
import com.loginmodel.loginmodel.dao.DBhelper;

import java.util.HashMap;
import java.util.Map;

public class LoginServletImpl extends BaseInitDBhelper implements LoginServlet
{ 	String tablename="users";
	String column="phonenumber";
	String column2="pwd";
	public  boolean InsertInfoToDB(String number,String password)
	{
	if(DBhelper.SearchMessageExit(tablename,column,number))return false;//号码已经存在，插入失�?
	//否则，可以插?

	String[] col= {column,column2};
	String[] info= {number,password};

	//TTOO 调用数据库的插入功能，在用户表中插入indo.getNumber(),info.getPassword()�?
	if(!DBhelper.Insert(tablename, col,info))return false;//插入失败
	return true;//否则，插入成功
}
	public boolean MatchInfo(String number,String password) {
		String[] col= {column,column2};
		String[] info= {number,password};
		if(DBhelper.MatchInfo(tablename,col , info))
		return true;
		else return false;

	}
	//mybatis新增
	public boolean PhoneExist(long phone) {
		// TODO Auto-generated method stub
		Map<String, User> info=new HashMap<String,User>();
		info= DBhelper.getUser(phone);
		if(info.get("user")==null)
		{
			return false;
		}
		else return true;
	}
	public String AddUser(long phone,String pwd)
	{
		if(PhoneExist(phone))
			return "0";
		DBhelper dBhelper =new DBhelper();
		dBhelper.addUser_phone_pwd(phone,pwd);
		return "1";

	}
	@Override
	public boolean UpdateUserInfo(long phone, User user) {
		if(!PhoneExist(phone))return false;
		// TODO Auto-generated method stub
		DBhelper.UpdateUserInfo(user);

		return true;
	}
	public User LoginByPwd(long phone)
	{
		User user=new User();
		String statement="UserMapper.getUserByPhone";
		user=session.selectOne(statement,phone);
		session.close();
		return user;
	}
	
	
	
};