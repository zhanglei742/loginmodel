package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.Itemsource;

public interface ItemsourceMapper {
    int deleteByPrimaryKey(Integer menukey);

	int insert(Itemsource record);

	int insertSelective(Itemsource record);

	Itemsource selectByPrimaryKey(Integer menukey);

	int updateByPrimaryKeySelective(Itemsource record);

	int updateByPrimaryKey(Itemsource record);
}