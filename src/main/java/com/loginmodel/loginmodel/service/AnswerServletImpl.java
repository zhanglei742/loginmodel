package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.dao.AnswerDao;
import com.loginmodel.loginmodel.dao.AnswerDaoImpl;
import com.loginmodel.loginmodel.dao.AskDao;
import com.loginmodel.loginmodel.dao.AskDaoImpl;
import com.loginmodel.loginmodel.domain.Answer;

public class AnswerServletImpl implements AnswerServlet{
    String all="";
    //存储回答的问题
    @Override
    public String AddAnswer(Answer answer) {
       //将回答的问题以及内容存到数据库
        AnswerDao answerDao =new AnswerDaoImpl();
        boolean  q= answerDao.addAnswer(answer);
        //更新专家数据库的回答数目

        if(q) {
            all = "1";
        }
        else
        {   all = "0";
        }

        return  all;

    }
    //存储回答表同时更新专家回答问题数
    @Override
    public String updateExpertCount(String string) {
        AnswerDao answerDao =new AnswerDaoImpl();
        boolean  p= answerDao.updateExpertCount(string);
        if(p) {
            all = "1";
        }
        else
        {   all = "0";
        }

        return  all;


    }
}
