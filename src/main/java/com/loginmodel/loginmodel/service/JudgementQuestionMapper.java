package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.JudgementQuestion;

public interface JudgementQuestionMapper {
    int deleteByPrimaryKey(Integer questionId);

    int insert(JudgementQuestion record);

    int insertSelective(JudgementQuestion record);

    JudgementQuestion selectByPrimaryKey(Integer questionId);

    int updateByPrimaryKeySelective(JudgementQuestion record);

    int updateByPrimaryKey(JudgementQuestion record);
}