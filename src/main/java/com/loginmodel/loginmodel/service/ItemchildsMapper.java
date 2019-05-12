package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.Itemchilds;

public interface ItemchildsMapper {
    int insert(Itemchilds record);

    int insertSelective(Itemchilds record);
}