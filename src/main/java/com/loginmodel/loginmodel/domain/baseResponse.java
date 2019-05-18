package com.loginmodel.loginmodel.domain;
//基础消息类，返回的都按照这个格式。
public class  baseResponse<T> {
	
	public baseResponse (int result,int count,T data,String error){
	
		this.result=result;
		this.count=count;
		this.data=data;
		this.error=error;
	}
	public int result;//返回结果成功/失败
	public int count;//data里的数据数量
	public T data;//数据列表
	//public Time time;//返回的当前时间
	public String error;//错误的话，错误信息。
	//public String success;//成功，且需要信息的话，成功信息（）————估计不会用到
}