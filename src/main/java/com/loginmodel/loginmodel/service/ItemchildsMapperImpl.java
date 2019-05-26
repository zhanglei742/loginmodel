package com.loginmodel.loginmodel.service;

import java.util.ArrayList;
import java.util.List;

import com.loginmodel.loginmodel.domain.Item;
import com.loginmodel.loginmodel.domain.Itemchilds;
import com.loginmodel.loginmodel.util.BaseInitDBhelper;

public class ItemchildsMapperImpl extends BaseInitDBhelper implements ItemchildsMapper {

	@Override
	public int insert(Itemchilds record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Itemchilds record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Item> selectchilditemsbyid(Integer itemid) {
		// TODO Auto-generated method stub
		List<Item> items=new ArrayList<>();
		String statement="ItemchildsMapper.selectchilditemsbyid";
		items= session.selectList(statement, itemid);
		
		session.close();
		return (ArrayList<Item>) items;
	}

}
