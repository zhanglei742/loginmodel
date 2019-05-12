package com.loginmodel.loginmodel.service;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.loginmodel.loginmodel.domain.Item;

public class ItemMapperImpl implements ItemMapper {

	public SqlSession session;

	public ItemMapperImpl() {//实例化的时候打开
		String resource = "spring-mybatis.xml";
		InputStream is = ItemMapperImpl.class.getClassLoader().getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		session = sessionFactory.openSession();
	}
	public void Close()//结束使用的时候关闭
	{
		if(session!=null)
		{
			session.close();
		}
	}

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
