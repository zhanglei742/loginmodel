package com.loginmodel.loginmodel.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginmodel.loginmodel.domain.Item;
import com.loginmodel.loginmodel.domain.Itemsource;
import com.loginmodel.loginmodel.domain.Sourcemenu;
import com.loginmodel.loginmodel.service.ItemMapper;
import com.loginmodel.loginmodel.service.ItemMapperImpl;
import com.loginmodel.loginmodel.service.ItemchildsMapper;
import com.loginmodel.loginmodel.service.ItemchildsMapperImpl;
import com.loginmodel.loginmodel.service.ItemsourceMapper;
import com.loginmodel.loginmodel.service.ItemsourceMapperImpl;
import com.loginmodel.loginmodel.service.SourcemenuMapper;
import com.loginmodel.loginmodel.service.SourcemenuMapperImpl;
import com.loginmodel.loginmodel.util.baseResponse;

@RestController
@RequestMapping("/main")
public class ItemController {

	@RequestMapping("/getitembyid")
	@ResponseBody
	public baseResponse<Item> getitembyid(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		baseResponse<Item> response = new baseResponse<>();
		Item data = new Item();

		if (req.getParameter("itemid") != null) {
			ItemMapper itemMapper = new ItemMapperImpl();
			data = itemMapper.selectByPrimaryKey(Integer.parseInt(req.getParameter("itemid")));

			if (data == null) {
				response.error = "NoDataRecorded";
			} else {
				response.setResult(1);
				response.setCount(1);
				response.setData(data);
			}
		} else
			response.error = "errorinput";
		return response;

	}

	@RequestMapping("/getchilditemsbyid")
	@ResponseBody
	public baseResponse<ArrayList<Item>> getchilditemsbyid(HttpServletRequest req, HttpServletResponse rep)
			throws Exception {
		baseResponse<ArrayList<Item>> response = new baseResponse<>();
		ArrayList<Item> data = new ArrayList<>();

		if (req.getParameter("itemid") != null) {
			ItemchildsMapper op = new ItemchildsMapperImpl();
			data = op.selectchilditemsbyid(Integer.parseInt(req.getParameter("itemid")));
			if (data.size() <= 0) {
				response.error = "NoDataRecorded";
			} else {
				response.setResult(1);
				response.setCount(data.size());
				response.setData(data);
			}

		} else {
			response.error = "errorinput";
		}

		return response;
	}

	@RequestMapping("/getitemsource")
	@ResponseBody
	public baseResponse<ArrayList<Itemsource>> getitemsource(HttpServletRequest req, HttpServletResponse rep) {
		baseResponse<ArrayList<Itemsource>> response = new baseResponse<>();
		ArrayList<Itemsource> data = new ArrayList<>();

		if (req.getParameter("itemid") != null) {
			ItemsourceMapper op = new ItemsourceMapperImpl();
			data = op.selectByItemid(Integer.parseInt(req.getParameter("itemid")));

			if (data.size() <= 0) {
				response.error = "NoDataRecorded";
			} else {
				response.setResult(1);
				response.setCount(data.size());
				response.setData(data);
			}
		} else {
			response.error = "errorinput";
		}
		return response;
	}

	@RequestMapping("/getsourcemenu")
	@ResponseBody
	public baseResponse<ArrayList<Sourcemenu>> getsourcemenu(HttpServletRequest req, HttpServletResponse rep) {
		baseResponse<ArrayList<Sourcemenu>> response = new baseResponse<>();
		ArrayList<Sourcemenu> data = new ArrayList<>();
		if (req.getParameter("menukey") != null) {
			SourcemenuMapper op = new SourcemenuMapperImpl();
			data = op.selectmenubykey(Integer.parseInt(req.getParameter("menukey")));

			if (data.size() <= 0) {
				response.error = "NoDataRecorded";
			} else {
				response.setResult(1);
				response.setCount(data.size());
				response.setData(data);
			}
		} else {
			response.error = "errorinput";
		}
		return response;
	}

	@RequestMapping("/searchonemenu")
	@ResponseBody
	public baseResponse<Sourcemenu> searchonemenu(HttpServletRequest req, HttpServletResponse rep) throws Exception {
		baseResponse<Sourcemenu> response = new baseResponse<>();
		Sourcemenu data = new Sourcemenu();

		if (req.getParameter("onemenuid") != null) {
			SourcemenuMapper op = new SourcemenuMapperImpl();
			data = op.SelectByPrimaryKey(Integer.parseInt(req.getParameter("onemenuid")));

			if (data == null) {
				response.setError("NoDataRecorded");
			} else {
				response.setResult(1);
				response.setCount(1);
				response.setData(data);
			}
		} else
			response.setError("errorinput");
		return response;
	}

}
