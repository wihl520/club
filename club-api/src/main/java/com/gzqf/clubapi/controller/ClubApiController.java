package com.gzqf.clubapi.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.clubapi.service.ApiLoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ClubApiController extends BaseController<ApiLoginService,Member> {

//    @Autowired
//    private ApiLoginService loginService;

    //登录的对象
    @RequestMapping(value = "/uilogin",produces = "application/json;charset=utf-8",method = RequestMethod.POST)
    @ResponseBody
    public String login(Member member){
        Member admin = Service.getByNameAndPassword(member);
        if(admin == null){
            return JSON.toJSONString(UserDto.fail("用户名或密码错误,请重新登录！！！"));
        }
        else {
            //根据账号和用户名再查询对象

            return JSON.toJSONString(UserDto.success("",admin));
        }

    }
}
