package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.UserItemTestMark;

public interface UserItemTestMarkMapper {
    int deleteByPrimaryKey(Integer thisid);

    int insert(UserItemTestMark record);

    int insertSelective(UserItemTestMark record);

    UserItemTestMark selectByPrimaryKey(Integer thisid);

    int updateByPrimaryKeySelective(UserItemTestMark record);

    int updateByPrimaryKey(UserItemTestMark record);
}