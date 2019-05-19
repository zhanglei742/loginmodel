package com.loginmodel.loginmodel.service;

import java.util.ArrayList;

import com.loginmodel.loginmodel.domain.Sourcemenu;

public interface SourcemenuMapper {
    int insert(Sourcemenu record);

    int insertSelective(Sourcemenu record);
    
    Sourcemenu SelectByPrimaryKey(Integer thisid);
    
    ArrayList<Sourcemenu> selectmenubykey(Integer menuid );
}