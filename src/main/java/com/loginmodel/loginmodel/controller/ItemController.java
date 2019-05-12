package com.loginmodel.loginmodel.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginmodel.loginmodel.domain.Item;
import com.loginmodel.loginmodel.service.ItemMapper;
import com.loginmodel.loginmodel.service.ItemMapperImpl;



@RestController
@RequestMapping("/main")
public class ItemController {

	@RequestMapping("/getitembyid")
	@ResponseBody
	public Item  getitembyid(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		Item item=new Item();
		if(req.getParameter("itemid")!=null) {
			ItemMapper itemMapper=new ItemMapperImpl();
			item=itemMapper.selectByPrimaryKey(Integer.parseInt(req.getParameter("itemid")));
			return item;
			
		}
		
		return null;
	}
	@RequestMapping("/getchilditemsbyid")
	@ResponseBody
	public Item[] getchilditemsbyid(HttpServletRequest req, HttpServletResponse rep) throws Exception 
	{
		ArrayList<Item> childs=new ArrayList<>();
		
		
		
		
		
		
		return null;
		
	}
	
}
