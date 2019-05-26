package com.loginmodel.loginmodel.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.apache.ibatis.cursor.Cursor;

import com.loginmodel.loginmodel.domain.ChoiceQuestion;
import com.loginmodel.loginmodel.util.BaseInitDBhelper;

public class ChoiceQuestionMapperImap extends BaseInitDBhelper implements ChoiceQuestionMapper {

	@Override
	public int deleteByPrimaryKey(Integer questionId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChoiceQuestion selectByPrimaryKey(Integer questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(ChoiceQuestion record) {
		// TODO Auto-generated method stub
		return 0;
	}

	/// 知识节点id，难度系数（属于哪一个测验），需要的题目数量，每个章节需要的数量。
	public ArrayList<ChoiceQuestion> getQuestions(Integer itemid, float rate, int count) {
		List<ChoiceQuestion> questions_select = new ArrayList<>();
		List<ChoiceQuestion> questions_all = new ArrayList<>();
		String statement = "ChoiceQuestionMapper.selectQuestionsByItemid";

		Cursor<ChoiceQuestion> cursor = session.selectCursor(statement, itemid);
		questions_all = MethodGetQuestion(cursor, rate, 1);// 允许难度系数误差为+-1；
		// 此时question得到了满足条件的题目，但是数量>需要的。
		int all = questions_all.size();
		if (all > count)// 题目的数量超过需要的,则分段取；否则（数量不够或者刚好），全部返回
		{
			float part = (float) all / count;// 将总的数量n分成count个区间。每个区间取一个。
			float low = 0;
			while (low + part <= all) {
				Random random = new Random();// Java的随机数是左开右闭的。
				int k = (int) Math.floor(random.nextFloat() * part + low + 0.5);
				questions_select.add(questions_all.get(k));
				low += part;
			}

		}

		try {
			cursor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.close();

		return (ArrayList<ChoiceQuestion>) questions_select;
	}

	// 设定获取题目的方法（考虑到难度系数，章节分配均匀，数量）——对该item的所有题目进行处理，有选择的（根据条件）传递给前端
	private List<ChoiceQuestion> MethodGetQuestion(Cursor<ChoiceQuestion> cursor, float rate, float range) {
		List<ChoiceQuestion> suit = new ArrayList<>();
		ChoiceQuestion question;
		Iterator<ChoiceQuestion> iter = cursor.iterator();
		while (iter.hasNext()) {
			question = iter.next();
			if (Math.abs(question.getDifficultyRate() - rate) <= range)// 误差在1 的范围内
			{
				suit.add(question);
			}
		}

		// while(cursor.get)
		return suit;
	}

}
