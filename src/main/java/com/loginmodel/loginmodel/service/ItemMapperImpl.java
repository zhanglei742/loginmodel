package com.loginmodel.loginmodel.service;

import com.loginmodel.loginmodel.domain.Item;

public class ItemMapperImpl extends BaseInitDBhelper implements ItemMapper {


	@Override
	public int deleteByPrimaryKey(Integer itemid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Item record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Item record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Item selectByPrimaryKey(Integer itemid) {
		
		Item item=new Item();
		String statement="ItemMapper.selectByPrimaryKey";
		item=session.selectOne(statement, itemid);
		session.close();
		return item;
	}

	@Override
	public int updateByPrimaryKeySelective(Item record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Item record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
