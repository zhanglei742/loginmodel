package com.loginmodel.loginmodel.dao;

import com.loginmodel.loginmodel.domain.*;
import com.loginmodel.loginmodel.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBhelper {
    static String sql = null;
    static DBUtil db1 = null;
    static ResultSet ret = null;
    static String resource = "spring-mybatis.xml";

    public static boolean Insert(String tableName, String[] colName, String[] values)
    {
        boolean finded=true;

        String temp_col=colName[0];//数组装换成对应格式的字符串?
        for(int i=1;i<colName.length;i++)
        {
            temp_col+=" , "+colName[i];
        }
        String temp_val=values[0];//数组装换成对应格式的字符串?
        for(int i=1;i<values.length;i++)
        {
            temp_val+="','"+values[i];
        }


        //编写sql语句
        String sql="insert into "+tableName+" ( "+temp_col+" ) values( '"+temp_val+"')";
        System.out.println(sql);
        //获得连接
        db1 = new DBUtil(sql);//创建DBHelper对象

        //实例化一个User对象
        try {
            db1.pst.execute();//执行语句，得到结果集

            //ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            finded=false;
            e.printStackTrace();
        }
        return finded;

    }


    public static boolean MatchInfo(String tableName,String[] col,String[] val)
    {
        if(col.length!=val.length)return false;//数量不对应，失败，退出
        for(int i=0;i<col.length;i++)
            if(!SearchMessageExit("users", col[i], val[i]))    //ifNull函数
            {
                return false;//有一项不匹配，则退出，返回失败
            }



        return true;//匹配成功
    }
    //表名冗余
    public static boolean UpdateNameByPhone(String tableName,String number,String name)
    {
        boolean finded=true;
        String sql=" UPDATE "+ tableName+" SET name = \""+name+"\" where number= "+number;
        db1 = new DBUtil(sql);//创建DBHelper对象

        //实例化一个User对象
        try {
            db1.pst.execute();
            //ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            finded=false;
            e.printStackTrace();
        }
        return finded;

    }


    public static boolean SearchMessageExit(String tableName,String col, String value )
    {
        boolean finded=false;

        //编写sql语句
        System.out.println("search"+value);
        String sql="select * from "+tableName+" where "+col+"= \""+value+"\"";
        //获得连接
        db1 = new DBUtil(sql);//创建DBHelper对象

        //实例化一个User对象
        try {
            ret = db1.pst.executeQuery();//执行语句，得到结果集
            if(ret.next()) {
                finded=true;
            }//显示数据
            ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return finded;
    }
    //忘记密码实现
    public static boolean UpdatePassword(String tableName, String phonenumber, String newpassword)
    {
        boolean finded=true;
        String sql=" UPDATE "+ tableName+" SET pwd = \""+newpassword+"\" where phonenumber= "+phonenumber;
        System.out.println("更新语句执行");
        db1 = new DBUtil(sql);//创建DBHelper对象

        //实例化一个User对象
        try {
            db1.pst.execute();
            //ret.close();
            db1.close();//关闭连接
        } catch (SQLException e) {
            finded=false;
            e.printStackTrace();
        }
        return finded;



    }
    //mybatis新增
    public static Map<String, User>  getUser(long phone)
    {
        SqlSessionFactory sessionFactory =null;
        try{
            //mybatis的配置文件
            // String resource = "spring-mybatis.xml";
            InputStream is = DBhelper.class.getClassLoader().getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(is);
        }catch (Exception e){
            System.out.println("连接失败");
            e.printStackTrace();
        }
            //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
            /**
             * 映射sql的标识字符串，
             * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
             */

        String statement = "UserMapper.getUser";//映射sql的标识字符串
            //执行查询返回一个唯一user对象的sql
        User user = session.selectOne(statement, phone);
        if(user == null){
            //号码不存在的情况
            System.out.println("号码不存在");
            Map<String, User> map = new HashMap<String, User>();
            map.put("user", null);
            return map;
        }
        System.out.println("获取的号码"+user.getPhonenumber());
        Map<String, User> info = new HashMap<String, User>();
        info.put("user", user);
        session.close();
        return info;
    }
    public static void addUser_phone_pwd(long phone,String pwd)
    {   SqlSessionFactory sessionFactory=null;
       // String resource = "spring-mybatis.xml";
        InputStream is = DBhelper.class.getClassLoader().getResourceAsStream(resource);

         sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        String statement = "UserMapper.addUser_phone_pwd";//映射sql的标识字符串
        User user=new User();
        user.setPwd(pwd);
        user.setPhonenumber(phone);
        user.setName(Long.toString(phone));
        int result= session.insert(statement,user);
        session.commit();
        session.close();
        System.out.println("DBhelperRun :" +result);

    }
    public static void UpdateUserInfo(User user)
    {
        String resource = "spring-mybatis.xml";
        InputStream is = DBhelper.class.getClassLoader().getResourceAsStream(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession session = sessionFactory.openSession();
        int [] result= {0,0,0};
        String statement ;
        System.out.println("DBhelper开始调用");
        if(user.getName()!=null){//输入名字不为空
            statement = "UserMapper.updateUser_name";//映射sql的标识字符串
            result[0]=session.update(statement,user);}
        if(user.getEmail()!=null) {//输入邮箱不为空
            statement = "UserMapper.updateUser_email";//映射sql的标识字符串
            result[1]=session.update(statement,user);System.out.println("邮箱");}
        if(user.getPwd()!=null) {//输入密码不为空
            statement = "UserMapper.updateUser_pwd";//映射sql的标识字符串
            result[2]=session.update(statement,user);}
        for(int i=0;i<3;i++)
        {
            System.out.println(i+" : "+result[i]);
        }
        session.commit();
        session.close();



    }


}
