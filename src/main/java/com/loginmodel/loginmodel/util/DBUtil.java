package com.loginmodel.loginmodel.util;

import javax.annotation.Resource;
import java.sql.*;
import java.util.Properties;

public class DBUtil {

	String url="";
	String name="";
	String user="";
	String password="";
	public Connection conn = null;
	public PreparedStatement pst = null;
	public ResultSet rst=null;

	void Init() throws Exception
	{
		Properties prop=new Properties();
		prop.load(Resource.class.getResourceAsStream("/application.properties"));
		url= prop.getProperty("mysql_url","");
		name=prop.getProperty("mysql_name","");
		user= prop.getProperty("mysql_user","");
		password= prop.getProperty("mysql_password","");
	}
	public DBUtil(String sql) {
		try {
			Init();
			Class.forName(name);//指定连接类型
			conn = DriverManager.getConnection(url, user, password);//获取连接
			pst = conn.prepareStatement(sql);//准备执行语句
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addUpDelExp(String sql) {
		try {
			PreparedStatement pStatement=conn.prepareStatement(sql);
			pStatement.executeUpdate();
		}catch (SQLException e) {
			System.out.println("mysql数据库增删改异常");
			e.printStackTrace();
		}
	}

	public ResultSet selectExp(String sql) {
		try {
			pst=conn.prepareStatement(sql);
			rst=pst.executeQuery(sql);
		}catch (SQLException e) {
			System.out.println("mysql数据库查询异常");
			e.printStackTrace();
		}
		return rst;
	}

	public void close() {
		try {
			this.conn.close();
			this.pst.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
