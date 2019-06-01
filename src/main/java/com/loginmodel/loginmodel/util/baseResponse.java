package com.loginmodel.loginmodel.util;

import java.security.Timestamp;
import java.sql.Time;

//基础消息类，返回的都按照这个格式。
public class  baseResponse<T> {

    public baseResponse (int result,int count,T data,String error){

        this.result=result;
        this.count=count;
        this.data=data;
        this.error=error;

    }
    public baseResponse (){

        this.result=0;
        this.count=0;
        this.data=null;
        this.error="NoError";
    }
    public int result;//返回结果成功/失败
    public int count;//data里的数据数量
    public T data;//数据列表
    //Timestamp
    //public Time time;//返回的当前时间
    public String error;//错误的话，错误信息。
    //public String success;//成功，且需要信息的话，成功信息（）————估计不会用到
    public int getResult() {
        return result;
    }
    public void setResult(int result) {
        this.result = result;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }
    @Override
    public String toString() {
        return "baseResponse [result=" + result + ", count=" + count + ", data=" + data + ", error=" + error + "]";
    }

}