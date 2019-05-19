package com.loginmodel.loginmodel.service;

import java.util.ArrayList;
import java.util.List;

import com.loginmodel.loginmodel.domain.Itemsource;
import com.loginmodel.loginmodel.domain.Sourcemenu;

public class SourcemenuMapperImpl extends BaseInitDBhelper implements SourcemenuMapper {

	@Override
	public int insert(Sourcemenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(Sourcemenu record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Sourcemenu> selectmenubykey(Integer menuid) {
		// TODO Auto-generated method stub
		List<Sourcemenu> source=new ArrayList<>();
		String statement="SourcemenuMapper.selectmenu";
		source=session.selectList(statement, menuid);
		session.close();
		return (ArrayList<Sourcemenu>)source;
	}

	@Override
	public Sourcemenu SelectByPrimaryKey(Integer thisid) {
		// TODO Auto-generated method stub
		Sourcemenu a_menu=new Sourcemenu();
		String statement="SourcemenuMapper.selectbyprimarykey";
		a_menu=session.selectOne(statement,thisid);
		return a_menu;
	}

}
