package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.*;
import com.loginmodel.loginmodel.util.JedisPoolUtils;
import com.loginmodel.loginmodel.util.MD5Util;
import redis.clients.jedis.Jedis;

public class VerificationCodeServletImpl implements VerificationCodeServlet {
	static int timeout = 180;
	Property propety =  new Property();
	MD5Util md5Util =new MD5Util();

	//接受手机号
	public boolean SendCode(String phone,String location) {
		// TODO Auto-generated method stub

		//阿里云生成并发送给用户
		String  code = "4321";
        /*propety.setPhone(phone);
        propety.setCode(code);
        propety.setLocation(location);*/
		//调用存储号码和验证码函数
		SaveCode(phone,location,code);

		return true;

	}

	//存储号码、位置、验证码
	public boolean SaveCode(String phone,String location,String code ){
		//得到手机号和验证码
		//加密操作
		String stringphone =md5Util.string2MD5(phone.toString())+"p";
		String stringlocation =md5Util.string2MD5(location.toString())+"l";
		String stringcode = md5Util.string2MD5(code.toString())+"c";
		try {

			//连接数据库并用hash存储（hset手机号、位置、验证码）
			JedisPoolUtils pool = new JedisPoolUtils();
			Jedis jedis = pool.getJedis();
			jedis.hset(stringphone, stringlocation,stringcode);
			//存储并设置生存时间
			//jedis.setex("integer1",60, "integer2");
			//jedis.expire过期机制，设定生存时间为180秒
			jedis.expire(stringphone, timeout);
			//使用之后记得关闭连接
			pool.closePool();
			jedis.close();

		} catch (Exception e) {

			// TODO: handle exception
			e.printStackTrace();
		}
		return true;

	}
	//匹配手机号、验证码

	public boolean CheckCode(String phone, String location,String code) {
		// TODO Auto-generated method stub
		boolean returnweb = false;
			//得到 前端发送来的手机号、位置、验证码 set get
			//根据手机号、位置，获得redis数据库的验证码
			JedisPoolUtils pool = new JedisPoolUtils();
			Jedis jedis = pool.getJedis();
			//加密前端传来的号码、位置
			String secondphone = md5Util.string2MD5(phone.toString())+"p";
			String secondlocation =md5Util.string2MD5(location.toString())+"l";
			String secondcode =md5Util.string2MD5(code.toString())+"c";
			//查询并获得号码、位置对应的验证码
			String string = jedis.hget(secondphone,secondlocation);
			//将string类型转换为integer，便于比较两个code
			//Integer sinteger = Integer.valueOf(string);

			//若前端的与数据库的匹配，进入主界面
			if (string!=null&&secondcode.equals(string)) {
				System.out.println("后端显示：查询成功");
				returnweb = true;
				//return true;
				//与前端交互，跳转到主界面

			} else {
				System.out.println("后端显示：查询失败");
				returnweb = false;
				//return false;
				//前端提示验证码错误
			}
			//使用之后记得关闭连接
			pool.closePool();
			jedis.close();


		return  returnweb;
	}

}
