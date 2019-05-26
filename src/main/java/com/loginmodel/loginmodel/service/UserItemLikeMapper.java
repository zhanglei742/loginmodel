package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.UserItemLike;

public interface UserItemLikeMapper {
    int deleteByPrimaryKey(Integer thisId);

    int insert(UserItemLike record);

    int insertSelective(UserItemLike record);

    UserItemLike selectByPrimaryKey(Integer thisId);

    int updateByPrimaryKeySelective(UserItemLike record);

    int updateByPrimaryKey(UserItemLike record);
}