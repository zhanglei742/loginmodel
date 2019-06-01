package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.dao.AskDao;
import com.loginmodel.loginmodel.dao.AskDaoImpl;
import com.loginmodel.loginmodel.domain.Ask;
import com.loginmodel.loginmodel.domain.Square;

import java.util.List;

public class AskServletImpl implements  AskServlet{


    String all="";
    //添加提问问题
    @Override
    public String AddQuestion(Ask ask) {
        AskDao askDao =new AskDaoImpl();
        boolean  q= askDao.addQuestion(ask);
        if(q) {
            all = "1";
        }
        else
        {   all = "0";
        }
        return all;
    }
    //在广场上显示出来(查询返回所有的数据)
    @Override
    public List<Square> asklist() {
        AskDao askDao =new AskDaoImpl();
        List<Square> asklistservice=askDao.asklistdao();

        return asklistservice;
    }
    //共享人数+1
    @Override
    public String sharePerson(String questionId) {

        AskDao askDao =new AskDaoImpl();
        boolean  q= askDao.sharenum(questionId);
        if(q) {
            all = "1";
        }
        else
        {   all = "0";
        }
        return all;
    }


}
