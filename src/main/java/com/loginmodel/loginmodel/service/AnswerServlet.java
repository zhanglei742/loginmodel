package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.Answer;
import com.loginmodel.loginmodel.domain.Ask;

public interface AnswerServlet {
    //存储回答的问题
    public String AddAnswer(Answer answer);
    //存储同时更新专家回答数量
    public String updateExpertCount(String string);
}
