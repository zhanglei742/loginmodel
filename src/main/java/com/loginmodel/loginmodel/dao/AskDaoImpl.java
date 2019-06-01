package com.loginmodel.loginmodel.dao;

import com.loginmodel.loginmodel.domain.Ask;
import com.loginmodel.loginmodel.domain.Square;
import com.loginmodel.loginmodel.service.BaseInitDBhelper;

import java.util.List;

public class AskDaoImpl extends BaseInitDBhelper implements AskDao{

    //提问问题添加
    @Override
    public boolean addQuestion(Ask ask) {
        try
        {
            String statement = "AskMapper.askInsert";//映射sql的标识字符串
            session.insert(statement,ask);//执行mapper的语句
            session.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }
    //从数据库查询所有的ask表，并返回
    @Override
    public List<Square> asklistdao()
    {

        List<Square> asklist =null;//定义一个list接受数据库返回的Ask列表
        String statement = "SquareMapper.selectAll";//映射sql的标识字符串
        asklist=session.selectList(statement); //接受数据库数据
        session.commit();
        session.close();
        return asklist;
    }
    //共享人数+1
    @Override
    public boolean sharenum(String questionId) {
        int a=0;
        try
        {
            String statement = "AskMapper.sharaNumber";//映射sql的标识字符串
            a=session.update(statement,questionId);//执行mapper的语句
            session.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        if (a>0)
            return true;
        else return false;


    }


}
