package com.loginmodel.loginmodel.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.scripting.xmltags.ChooseSqlNode;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.loginmodel.loginmodel.domain.ChoiceOptions;
import com.loginmodel.loginmodel.domain.ChoiceQuestion;
import com.loginmodel.loginmodel.domain.Choice_Question_Answer;
import com.loginmodel.loginmodel.service.ChoiceOptionsMapper;
import com.loginmodel.loginmodel.service.ChoiceOptionsMapperImpl;
import com.loginmodel.loginmodel.service.ChoiceQuestionMapper;
import com.loginmodel.loginmodel.service.ChoiceQuestionMapperImap;
import com.loginmodel.loginmodel.util.baseResponse;

@RestController
@RequestMapping("/Test")
public class UserTestController {

	@RequestMapping("/getquestionsbyitemid")
	@ResponseBody
	public baseResponse<ArrayList<Choice_Question_Answer>> getquestionsbyitemid(HttpServletRequest req,
			HttpServletResponse rep) {
		baseResponse<ArrayList<Choice_Question_Answer>> response = new baseResponse<>();
		ArrayList<Choice_Question_Answer> data = new ArrayList<>();
		ArrayList<ChoiceQuestion> questions = new ArrayList<>();
		ArrayList<ChoiceOptions> options = new ArrayList<>();

		if (req.getParameter("itemid") != null && req.getParameter("diffcultyrate") != null) {

			int itemid = Integer.parseInt(req.getParameter("itemid"));
			float diffcultyrate = Float.parseFloat(req.getParameter("diffcultyrate"));
			ChoiceQuestionMapper op = new ChoiceQuestionMapperImap();

			// TODO
			// count数量根据itemid，去对应的题目数量表，来查找。先暂时设置数量为20.
			int count = 20;
			// TODO
			// 得到数量<=count 的问题
			questions = op.getQuestions(itemid, diffcultyrate, count);
			if (questions.size() <= 0) {//该知识点没有问题
				response.setError("NoDataRecorded");
			} else {
				ChoiceOptionsMapper op2 = new ChoiceOptionsMapperImpl();
				// 遍历问题，得到答案，同时封装成问题答案一体的类。添加到返回列表
				for (int i = 0; i < questions.size(); i++) {
					options = op2.selectByQuestionId(questions.get(i).getQuestionId());
					data.add(new Choice_Question_Answer(questions.get(i), options));
				}
				response.setResult(1);
				response.setCount(data.size());
				response.setData(data);
			}

		} else {
			response.setError("errorInput");
		}
		return response;

	}
}
