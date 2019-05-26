package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.UserLearningScheme;

public interface UserLearningSchemeMapper {
    int deleteByPrimaryKey(Integer sourceMenuId);

    int insert(UserLearningScheme record);

    int insertSelective(UserLearningScheme record);

    UserLearningScheme selectByPrimaryKey(Integer sourceMenuId);

    int updateByPrimaryKeySelective(UserLearningScheme record);

    int updateByPrimaryKey(UserLearningScheme record);
}