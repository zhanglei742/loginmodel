package com.loginmodel.loginmodel.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.cursor.Cursor;

import com.loginmodel.loginmodel.domain.ChoiceOptions;
import com.loginmodel.loginmodel.domain.ChoiceQuestion;
import com.loginmodel.loginmodel.util.BaseInitDBhelper;

public class ChoiceOptionsMapperImpl extends BaseInitDBhelper implements ChoiceOptionsMapper {

	@Override
	public int deleteByPrimaryKey(Integer optionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ChoiceOptions record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ChoiceOptions record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChoiceOptions selectByPrimaryKey(Integer optionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ChoiceOptions record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ChoiceOptions record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ChoiceOptions> selectByQuestionId(Integer questionid) {
		List<ChoiceOptions> data = new ArrayList<>();
		String statement = "ChoiceOptionsMapper.selectByQuestionId";
		data = session.selectList(statement, questionid);
		session.close();
		return (ArrayList<ChoiceOptions>) data;
	}

}
