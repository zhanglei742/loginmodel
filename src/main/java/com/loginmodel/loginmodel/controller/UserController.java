package com.loginmodel.loginmodel.controller;

import com.loginmodel.loginmodel.service.*;
import com.loginmodel.loginmodel.util.baseResponse;
import com.loginmodel.loginmodel.domain.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/start")
public class UserController {

	// //发送验证码
	// @RequestMapping("/sendcode")
	// @ResponseBody
	// //======注解方式 参数
	// public String SendCode(HttpServletRequest request, HttpServletResponse
	// response) throws Exception {
	// //HttpServletRequest req, HttpServletResponse rep
	// String webphone = request.getParameter("phonenumber");
	// String weblocation = request.getParameter("location");
	// //String webphone ="130";
	// //String weblocation ="1";
	// System.out.println("后端接受用户第一次传来的信息");
	//
	// //======添加service层
	// VerificationCodeServlet verificationCode = new VerificationCodeServletImpl();
	// if (verificationCode.SendCode(webphone, weblocation)) {
	// //返回1表明验证码无误并成功
	// return "1";
	// } else
	// //返回1表明验证码输入错误
	// return "0";
	//
	// }
	// //匹配验证码
	// @RequestMapping("/checkcode")
	// @ResponseBody
	// public String CheckCode(HttpServletRequest request, HttpServletResponse
	// response)throws Exception
	// {
	// //Integer phone, Integer location, Integer code
	//// String phone1 ="130";
	//// String location2 ="1";
	//// String code3 = "4321";
	// String secondphone =request.getParameter("phonenumber");
	// String secondlocation =request.getParameter("location");
	// String secondcode =request.getParameter("code");
	// System.out.println("匹配验证码信息：用户第二次传来的手机号为：" + secondphone + "；功能位置：" +
	// secondlocation+ "；验证码：" + secondcode);
	//
	// VerificationCodeServlet verificationCode = new VerificationCodeServletImpl();
	// if (verificationCode.CheckCode(secondphone, secondlocation,secondcode)) {
	// return "传给前端：信息已经匹配";
	// } else
	// return "传给前端：信息不匹配";
	// }
	// @RequestMapping("/login")
	// @ResponseBody
	// //注解方式获取参数
	// public String Login(HttpServletRequest req, HttpServletResponse rep) throws
	// Exception {
	// String username = req.getParameter("phonenumber");
	// String pass = req.getParameter("pwd");
	// System.out.println("使用Spring内置的支持" + username + "--->" + pass);
	// //确实service层
	// LoginServlet op = new LoginServletImpl();
	// if (op.MatchInfo(username, pass)) {
	// return "成功";
	// } else
	// return "失败";
	// }
	// @RequestMapping("/register")
	// @ResponseBody
	// public String Register(HttpServletRequest req, HttpServletResponse rep)
	// throws Exception {
	// String username = req.getParameter("phonenumber");
	// String pass = req.getParameter("pwd");
	// System.out.println("使用Spring内置的支持" + username + "--->" + pass);
	// LoginServlet op = new LoginServletImpl();
	// if (op.InsertInfoToDB(username, pass)) {
	// return "1";
	// } else
	// return "0";
	// }
	// 忘记密码功能
	@RequestMapping("/forgetpassword")
	@ResponseBody
	// ======注解方式 参数
	public String ForgetPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String webphone = request.getParameter("phonenumber");
		String newpassword = request.getParameter("pwd");
		System.out.println("已接受前端发来信息");
		// ======添加service层
		ChangePasswordServlet changePassword = new ChangePasswordServletImpl();
		if (changePassword.ForgetPassword(webphone, newpassword)) {
			// 返回1表明忘记密码修改成功
			return "1";
		} else
			// 返回1表明忘记密码修改失败
			return "0";

	}

	@RequestMapping("/loginbypwd")
	@ResponseBody
	public baseResponse<User> loginbypwd(HttpServletRequest req, HttpServletResponse rep) {
		baseResponse<User> response = new baseResponse<>();
		User data = new User();
		if (req.getParameter("phonenumber") != null && req.getParameter("pwd") != null) {
			LoginServlet op = new LoginServletImpl();
			data = op.LoginByPwd(Long.parseLong(req.getParameter("phonenumber")));
			if (data == null) {
				response.setError("NoDataRecorded");
			} else if (!req.getParameter("pwd").toString().equals(data.getPwd())) {
				response.setCount(1);
				response.setError("ErrorPwd");

			} else {
				response.setResult(1);
				response.setCount(1);
				data = new User();
				data.setPhonenumber(Long.parseLong(req.getParameter("phonenumber")));
				response.setData(data);
			}
		} else
			response.setError("errorinput");

		// baseResponse<ArrayList<Item>> response = new baseResponse<>(result, size,
		// childs, message);
		return response;
	}

	// mybatis新增
	@RequestMapping("/ifphoneexit")
	@ResponseBody
	public String IfPhoneExit(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		long phone = 0;
		if (req.getParameter("phonenumber") != null) {
			phone = Long.parseLong(req.getParameter("phonenumber"));
		}
		LoginServlet op = new LoginServletImpl();
		System.out.println(phone + " : 号码是否存在?");
		if (op.PhoneExist(phone)) {
			return "号码已经存在";
		} else
			return "号码不存在";
	}

	@RequestMapping("/adduser")
	@ResponseBody
	public String AddUser(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		long phone = 0;
		String pwd = "";
		if (req.getParameter("phonenumber") != null && req.getParameter("pwd") != null) {
			phone = Long.parseLong(req.getParameter("phonenumber"));
			pwd = req.getParameter("pwd");
		}

		LoginServlet op = new LoginServletImpl();
		System.out.println(phone + " : 开始插入");
		if (op.AddUser(phone, pwd) == "1") {
			return phone + " : 插入成功";
		} else
			return phone + ": 插入失败";
	}

	@RequestMapping("/updateuserinfo")
	@ResponseBody
	public String UpdateUserInfo(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		User user = new User();
		if (req.getParameter("phonenumber") != null) {
			user.setPhonenumber(Long.parseLong(req.getParameter("phonenumber")));
		} else
			return "error：手机号为空";
		if (req.getParameter("username") != null) {
			user.setName(req.getParameter("username"));

		}
		if (req.getParameter("pwd") != null) {
			user.setPwd(req.getParameter("pwd"));
		}
		if (req.getParameter("email") != null) {
			// System.out.println("0---email"+req.getParameter("email"));
			user.setEmail(req.getParameter("email"));
			// System.out.println("1---email"+user.getEmail());

		}
		LoginServlet op = new LoginServletImpl();
		// System.out.println(user.getPhonenumber()+" : 更改名字");
		if (op.UpdateUserInfo(user.getPhonenumber(), user)) {

			return req.getParameter("phonenumber") + "：更新用户信息成功";
		} else

			return req.getParameter("phonenumber") + "：更新用户信息失败";
	}

}