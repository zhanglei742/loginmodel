package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.ChoiceOptions;

public interface ChoiceOptionsMapper {
    int deleteByPrimaryKey(Integer optionId);

    int insert(ChoiceOptions record);

    int insertSelective(ChoiceOptions record);

    ChoiceOptions selectByPrimaryKey(Integer optionId);

    int updateByPrimaryKeySelective(ChoiceOptions record);

    int updateByPrimaryKey(ChoiceOptions record);
}