package com.gzqf.clubapi.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.*;
import com.gzqf.club.persistence.Result;
import com.gzqf.clubapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;


@Controller
public class ApiController {
    @Autowired
    private IClubService iClubService;
    @Autowired
    private MemBerService memBerService;
    @Autowired
    private MemDeadService memDeadService;
    @Autowired
    private OrderService orderService;

    //新闻推送
    @Autowired
    private PushService pushService;

    @RequestMapping(value = "/getPush",produces = "application/json;charset=utf-8")
    @ResponseBody
    public  String getPush(){
        List<NewsPush> push = pushService.getPush();
        return JSON.toJSONString(push);
    }

    @RequestMapping(value = "/findList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String showTeam(){
        List<Member> list = iClubService.findList();
        return JSON.toJSONString(list);
    }
    @RequestMapping(value = "/findAppcatAll",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String showAppcatAll(){
        List<Appcat> list = iClubService.findAppcatAll();
        return JSON.toJSONString(list);
    }

    //findcoachInfo
    @RequestMapping(value = "/findcoachInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findcoachInfo(String id){
        Long Id = Long.parseLong(id);
        Member member = iClubService.findcoachInfo(Id);
        return JSON.toJSONString(member);
    }
    //findStuList
    @RequestMapping(value = "/findStuList",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String findStuList(String id){
        Long Id = Long.parseLong(id);
        List<Member> list = iClubService.findStuList(Id);
        return JSON.toJSONString(list);
    }

    /*订单请求*/
    @RequestMapping(value = "/member/changeforms")
    public Result changeforms(Long id,int totalDay,int payAmount,String payWay){
        /*修改用户表的会员天数-成功*/
        Member member = memBerService.getById(id);
        member.setMemberDay(member.getMemberDay()+totalDay);
        memBerService.updateMemberday(member);
        /*添加期限表的天数 -成功*/
        MemberDeadline deadline = memDeadService.getById(id);
        deadline.setTotalDay(totalDay+deadline.getTotalDay());
        memDeadService.updateDate(deadline);
        /*添加订单表 - 失败*/
        Order order = new Order();
        order.setPayAmount(payAmount);
        order.setPayWay(payWay);
        order.setMemberId(id.intValue());
        order.setPayDate(new Date());
        order.setTotalDay(totalDay);
        Result saveresult = orderService.save(order);
        return saveresult;
    }

}
