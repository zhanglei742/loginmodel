package com.loginmodel.loginmodel.service;

import java.util.ArrayList;

import com.loginmodel.loginmodel.domain.Item;
import com.loginmodel.loginmodel.domain.Itemchilds;

public interface ItemchildsMapper {
    int insert(Itemchilds record);

    int insertSelective(Itemchilds record);
    
    ArrayList<Item> selectchilditemsbyid(Integer itemid);
}