package com.loginmodel.loginmodel.dao;

import com.loginmodel.loginmodel.domain.Answer;
import com.loginmodel.loginmodel.domain.Ask;
import com.loginmodel.loginmodel.service.BaseInitDBhelper;

public class AnswerDaoImpl extends BaseInitDBhelper implements AnswerDao {
    //提问问题添加
    @Override
    public boolean addAnswer(Answer answer) {
            try
            {
                String statement = "AnswerMapper.answerInsert";//映射sql的标识字符串
                session.insert(statement,answer);//执行mapper的语句
                session.commit();
                session.close();
            }catch (Exception e){
                e.printStackTrace();
            }

            return true;

    }


    //更新专家表的回答数量
    @Override
    public boolean updateExpertCount(String string) {
        try
        {

            String statement = "AnswerMapper.updateExpertCount";//映射sql的标识字符串
            session.update(statement,string);//执行mapper的语句
            session.commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return true;
    }
}
