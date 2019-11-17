package com.gzqf.webui.controller;

import com.gzqf.club.entity.Member;
import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.webui.service.WebUiMemberPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class WebUiMemberPayController {

    @Autowired
    private WebUiMemberPayService webUiMemberPayService;

    //跳转到支付页面
    @RequestMapping(value = "/memberpay")
    public String membertopay(HttpSession session){
        return "member/pay";
    }

    //用户支付
    @RequestMapping(value = "/paymoney")
    public String paymoney(Order order, HttpServletRequest req){
        Order paylaterorder =  webUiMemberPayService.pay(order);
        /*支付成功*/
        if (paylaterorder!=null){
            return "/member/paylater";
        }
        else{
           /*支付失败应该另外跳转*/
            return "/member/paylater";
        }
    }

}
