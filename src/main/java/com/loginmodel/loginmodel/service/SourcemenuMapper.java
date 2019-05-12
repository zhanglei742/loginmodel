package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.Sourcemenu;

public interface SourcemenuMapper {
    int insert(Sourcemenu record);

    int insertSelective(Sourcemenu record);
}