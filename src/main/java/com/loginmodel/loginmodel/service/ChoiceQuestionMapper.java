package com.loginmodel.loginmodel.service;

import java.util.ArrayList;

import com.loginmodel.loginmodel.domain.ChoiceQuestion;

public interface ChoiceQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(ChoiceQuestion record);

    int insertSelective(ChoiceQuestion record);

    ChoiceQuestion selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(ChoiceQuestion record);

    int updateByPrimaryKey(ChoiceQuestion record);
    
    ArrayList<ChoiceQuestion> getQuestions(Integer itemid,float rate,int count);
}