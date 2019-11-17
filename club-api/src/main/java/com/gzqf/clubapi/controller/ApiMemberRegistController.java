package com.gzqf.clubapi.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.clubapi.service.ApiMemberRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiMemberRegistController extends BaseController<ApiMemberRegistService,Member> {


    //验证用户和电子邮箱是否唯一
    @RequestMapping(value = "verifymember",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String verifymember(Member member){
        UserDto<Member> userDto;
        userDto = Service.verifymember(member);
        String str= JSON.toJSONString(userDto);
        return str;
    }
    //注册
    @RequestMapping(value = "registmember",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String registmember(Member member){
        UserDto<Member> userDto = Service.registmember(member);
        return JSON.toJSONString(userDto);
    }
    //修改用户
    @RequestMapping(value = "memberament",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String memberament(Member member,String personsex,String personid,String personage){
        member.setId(Long.parseLong(personid));
        member.setAge(Integer.parseInt(personage));
        UserDto<Member> userDto;
        userDto = Service.memberament(member,personsex);
        String s = JSON.toJSONString(userDto);
        return s;
    }
    //修改用户密码
    @RequestMapping(value = "amemdmemberpassword",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String amemdmemberpassword(String id,String password,String newpassword){
        UserDto<Member> userDto;
        userDto = Service.amemdmemberpassword(id,password,newpassword);
        return JSON.toJSONString(userDto);
    }
}
