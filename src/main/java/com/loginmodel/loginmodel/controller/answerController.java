package com.loginmodel.loginmodel.controller;

import com.loginmodel.loginmodel.domain.Answer;
import com.loginmodel.loginmodel.domain.Ask;
import com.loginmodel.loginmodel.service.AnswerServlet;
import com.loginmodel.loginmodel.service.AnswerServletImpl;
import com.loginmodel.loginmodel.service.AskServlet;
import com.loginmodel.loginmodel.service.AskServletImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/answer")
public class answerController {

    private Answer answer=new Answer();
    String result;
    //点击回答，将问题存到数据库
    @RequestMapping("/saveanswer")
    public String AnswerSave(HttpServletRequest request, HttpServletResponse response)
    {
    //http://localhost:8080/answer/saveanswer?answername=马修&answertime=2015-05-06 12:00:00&answertoperson=张三&questionid=cea010cfcd124c7098f6e88da23f05ed&answerinformation=回答具体内容
        answer.setAnswerName(request.getParameter("answername"));
        answer.setAnswerTime(Timestamp.valueOf(request.getParameter("answertime")));
        answer.setAnswerToPerson(request.getParameter("answertoperson"));
        answer.setQuestionId(request.getParameter("questionid"));
        answer.setAnswerInformation(request.getParameter("answerinformation"));
        System.out.println("接受前端回答问题功能数据"+answer);
        //存储数据到问题表ask

        AnswerServlet answerServlet=new AnswerServletImpl();
        result=answerServlet.AddAnswer(answer);
        System.out.println("回答已存储");

        String result1=answerServlet.updateExpertCount(answer.getAnswerName());
        System.out.println("专家问题数已更新");
        if (result=="1"&result1=="1") {
            //已存，存储数据成功
            return "1";
        } else
            //存储数据失败
            return "0";

    }


}

