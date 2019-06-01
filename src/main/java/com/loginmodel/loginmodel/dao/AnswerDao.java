package com.loginmodel.loginmodel.dao;

import com.loginmodel.loginmodel.domain.Answer;
import com.loginmodel.loginmodel.domain.Ask;

public interface AnswerDao {

    //添加回答
    boolean addAnswer(Answer answer);
    //更新专家表的回答数量
    boolean updateExpertCount(String string);
}
