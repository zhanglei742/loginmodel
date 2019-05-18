package com.loginmodel.loginmodel.service;

import java.util.ArrayList;
import java.util.List;

import com.loginmodel.loginmodel.domain.Item;
import com.loginmodel.loginmodel.domain.Itemsource;

public class ItemsourceMapperImpl extends BaseInitDBhelper implements ItemsourceMapper {

	@Override
	public int deleteByPrimaryKey(Integer menukey) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Itemsource record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Itemsource record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Itemsource selectByPrimaryKey(Integer menukey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(Itemsource record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(Itemsource record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Itemsource> selectByItemid(Integer itemid) {
		// TODO Auto-generated method stub
		List<Itemsource> source=new ArrayList<>();
		String statement="ItemsourceMapper.selectByitemid";
		source=session.selectList(statement, itemid);
		session.close();
		return (ArrayList<Itemsource>)source;
	}

}
