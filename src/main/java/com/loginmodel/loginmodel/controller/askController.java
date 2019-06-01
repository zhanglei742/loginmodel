package com.loginmodel.loginmodel.controller;
import com.loginmodel.loginmodel.domain.Ask;
import com.loginmodel.loginmodel.domain.Square;
import com.loginmodel.loginmodel.service.AskServlet;
import com.loginmodel.loginmodel.service.AskServletImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ask")
public class askController {
    private Ask ask=new Ask();

    private Square square=new Square();
    //@Resource
    //private AskServlet askServlet;
    String result;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date = null;
    //点击发布，将问题存到数据库
    @RequestMapping("/saveask")
    public String AskSave(HttpServletRequest request, HttpServletResponse response)
    {
        // localhost:8080/ask/saveask?askname=爱车&asktime=2019-04-20 16:40:00&asktoperson=马修&questiontitle=问题标题啊啊&questiondetail=问题描述
        ask.setAskName(request.getParameter("askname"));
        ask.setAskTime(Timestamp.valueOf(request.getParameter("asktime")));
        ask.setAskToPerson(request.getParameter("asktoperson"));
        ask.setQuestionTitle(request.getParameter("questiontitle"));
        ask.setQuestionDetail(request.getParameter("questiondetail"));
        //uuid生成questionId
        ask.setQuestionId(UUID.randomUUID().toString().replace("-", ""));
        System.out.println("接受前端提问功能数据"+ask);
        //存储数据到问题表ask

        AskServlet askServlet=new AskServletImpl();
        result=askServlet.AddQuestion(ask);
        System.out.println("问题已存储");
        if (result=="1") {
            //已存，存储数据成功
            return "1";
        } else
            //存储数据失败
            return "0";

    }

    //在广场上显示出来(查询返回所有的数据)
    @RequestMapping("/allask")
    public List<Square> askList(HttpServletRequest request, HttpServletResponse response)
    {
        AskServlet askServlet=new AskServletImpl();
        List<Square> askList=askServlet.asklist();

        System.out.println("提问广场获取数据库数据：大小"+ askList.size()+"List<Square>内容"+askList.toString());

       // System.out.println("格式前的UUID ： " + UUID.randomUUID().toString().replace("-", ""));
        return  askList;
    }

    //付费共享，人数+1
    @RequestMapping("/sharenumber")
    public String sharePersonNumber(HttpServletRequest request, HttpServletResponse response)
    {   //获取该问题的ID
        String questionId=request.getParameter("questionid");
        System.out.println("问题ID"+questionId);
        AskServlet askServlet=new AskServletImpl();
        result=askServlet.sharePerson(questionId);

        if (result=="1") {
            //已存，存储数据成功
            System.out.println("共享成功，人数增加");
            return "1";
        } else
            //存储数据失败
            System.out.println("共享失败");
            return "0";
    }

    /*@RequestMapping("/getitembyid")
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
*/


}

