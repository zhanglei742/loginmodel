package com.loginmodel.loginmodel.service;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//基础数据库操作帮助类，实例化session。关闭session
public class BaseInitDBhelper {
	public SqlSession session;

	public BaseInitDBhelper() {//实例化的时候打开
		String resource = "spring-mybatis.xml";
		InputStream is = ItemMapperImpl.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession();
	}
	public void Close()//结束使用的时候关闭
	{
		if(session!=null)
		{
			session.close();
		}
	}
}
