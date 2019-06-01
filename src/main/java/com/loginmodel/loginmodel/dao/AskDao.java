package com.loginmodel.loginmodel.dao;

import com.loginmodel.loginmodel.domain.Ask;
import com.loginmodel.loginmodel.domain.Square;

import java.util.List;

public interface AskDao {
    //添加问题
    boolean addQuestion(Ask ask);
    //查询整个ask表
    public List<Square> asklistdao();
    //共享人数+1
    public boolean sharenum(String questionId);
}
