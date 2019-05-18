package com.loginmodel.loginmodel.controller;

import java.sql.Time;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginmodel.loginmodel.domain.Item;
import com.loginmodel.loginmodel.domain.Itemsource;
import com.loginmodel.loginmodel.domain.Sourcemenu;
import com.loginmodel.loginmodel.domain.baseResponse;
import com.loginmodel.loginmodel.service.ItemMapper;
import com.loginmodel.loginmodel.service.ItemMapperImpl;
import com.loginmodel.loginmodel.service.ItemchildsMapper;
import com.loginmodel.loginmodel.service.ItemchildsMapperImpl;
import com.loginmodel.loginmodel.service.ItemsourceMapper;
import com.loginmodel.loginmodel.service.ItemsourceMapperImpl;
import com.loginmodel.loginmodel.service.SourcemenuMapper;
import com.loginmodel.loginmodel.service.SourcemenuMapperImpl;

import net.minidev.json.reader.JsonWriter;



@RestController
@RequestMapping("/main")
public class ItemController {

	@RequestMapping("/getitembyid")
	@ResponseBody
	public baseResponse<Item>  getitembyid(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		Item item=new Item();
		int result=0;
		int size=0;
		String message="success";
		if(req.getParameter("itemid")!=null) {
			ItemMapper itemMapper=new ItemMapperImpl();
			item=itemMapper.selectByPrimaryKey(Integer.parseInt(req.getParameter("itemid")));
			result=1;
			if(item!=null)size=1;else size=0;
			if(size<=0) {
				result=0;
				message="NoDataRecorded";
			}
		}
		else message="errorinput";
		return new baseResponse<Item>(result, size, item, message);
	}
	@RequestMapping("/getchilditemsbyid")
	@ResponseBody
	public baseResponse<ArrayList<Item>> getchilditemsbyid(HttpServletRequest req, HttpServletResponse rep) throws Exception 
	{	
		ArrayList<Item> childs=new ArrayList<>();
		int result=0;
		int size=0;
		String message="success";
		if(req.getParameter("itemid")!=null)
		{
			ItemchildsMapper op=new ItemchildsMapperImpl();
			childs=op.selectchilditemsbyid(Integer.parseInt(req.getParameter("itemid")));
			size=childs.size();
			result=1;
			if(size<=0) {
				result=0;
				message="NoDataRecorded";
			}
		}
		else message="errorinput";
		
		baseResponse<ArrayList<Item>> response=new baseResponse<>(result,size,childs,message);
		return response;
	}
	@RequestMapping("/getitemsource")
	@ResponseBody
	public baseResponse<ArrayList<Itemsource>> getitemsource(HttpServletRequest req, HttpServletResponse rep) throws Exception 
	{	
		ArrayList<Itemsource> source=new ArrayList<>();
		int result=0;
		int size=0;
		String message="success";
		if(req.getParameter("itemid")!=null)
		{
			ItemsourceMapper op=new ItemsourceMapperImpl();
			source=op.selectByItemid(Integer.parseInt(req.getParameter("itemid")));
			size=source.size();
			result=1;
			if(size<=0) {
				result=0;
				message="NoDataRecorded";
			}
		}
		else message="errorinput";
		baseResponse<ArrayList<Itemsource>> response=new baseResponse<>(result,size,source,message);
		return response;
	}
	@RequestMapping("/getsourcemenu")
	@ResponseBody
	public baseResponse<ArrayList<Sourcemenu>> getsourcemenu(HttpServletRequest req, HttpServletResponse rep) throws Exception 
	{	
		ArrayList<Sourcemenu> source=new ArrayList<>();
		int result=0;
		int size=0;
		String message="success";
		if(req.getParameter("menukey")!=null)
		{
			SourcemenuMapper op=new SourcemenuMapperImpl();
			source=op.selectmenubykey(Integer.parseInt(req.getParameter("menukey")));
			size=source.size();
			result=1;
			if(size<=0) {
				result=0;
				message="NoDataRecorded";
			}
		}
		else message="errorinput";
		baseResponse<ArrayList<Sourcemenu>> response=new baseResponse<>(result,size,source,message);
		return response;
	}
	
}
