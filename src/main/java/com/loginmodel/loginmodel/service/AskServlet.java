package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.Ask;
import com.loginmodel.loginmodel.domain.Square;

import java.util.List;

public interface AskServlet {

    public String AddQuestion(Ask ask);
    //问题广场
    public List<Square> asklist();
    //共享人数
    public String sharePerson(String questionId);
}
