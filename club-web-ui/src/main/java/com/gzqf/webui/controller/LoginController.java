package com.gzqf.webui.controller;

import com.google.code.kaptcha.Constants;
import com.gzqf.club.entity.Member;
import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.utils.CookieUtils;
import com.gzqf.webui.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    //3则重构 这是记住cookie名字
    private  static  final  String REMEBER_AUTO_LOGIN = "memberautologin";
    private  static  final  String REMEBER_Member = "member";
    private  static  final  String REMEBER_UserDto = "userDto";
    private  static  final  String REMEBER_Message = "message";

    @Autowired
    private LoginService Service;


    @RequestMapping(value = "/realLogin")
    public String  login(Member member, UserDto userDto, String remember, String autologin , Model model, HttpServletRequest req, HttpServletResponse resp){


        HttpSession session = (HttpSession) req.getSession();
        //验证码的判断
        //从session中取出验证码
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        userDto = Service.VerificationCode(userDto.getVerificationcode(),code,userDto);
        if (UserDto.FAIL_STATUS == userDto.getStatus()) {
            model.addAttribute(REMEBER_Message, userDto.getMessage());
            return "/login";
        }
        //用户账号密码判断是否正确
        userDto = Service.adminlogin(member);

        //当出错误时
        if (UserDto.FAIL_STATUS == userDto.getStatus()) {
            model.addAttribute(REMEBER_Message, userDto.getMessage());
            return "/login";
        }
        else {
            //使用userdto对象存储数据
            doremember(remember,autologin, userDto);
            /*如果有确认或者保存*/
            if (userDto.isAutologin() || userDto.isRemember()){
                CookieUtils.setCookie(req, resp, REMEBER_AUTO_LOGIN, String.format("%s:%s:%s:%s", member.getName(), member.getPassword(),userDto.isRemember(),userDto.isAutologin()), 7 * 24 * 60 * 60);
            }
            else{
                CookieUtils.setCookie(req, resp, REMEBER_AUTO_LOGIN, String.format("%s:%s:%s:%s", member.getName(), member.getPassword(),userDto.isRemember(),userDto.isAutologin()), -1);
            }
            //登录成功后的session
            member = (Member) userDto.getData();

            session.setAttribute(REMEBER_Member,member);
            session.setAttribute(REMEBER_UserDto,userDto);
            //重定向
            return "redirect:/index";
        }
    }

    //是否记住或者自动登录的对象赋值
    private void doremember(String remember, String autologin, UserDto userDto) {
        if ("on".equals(remember)){
            userDto.setRemember(true);
        }
        else{
            userDto.setRemember(false);
        }
        if ("on".equals(autologin)){
            userDto.setAutologin(true);
        }
        else{
            userDto.setAutologin(false);
        }
    }
    //注销用户操作
    @RequestMapping("/LogoutUser")
    public  String LogoutUser(HttpServletRequest req,HttpServletResponse resp,HttpSession session){
        Member member  =(Member) session.getAttribute(REMEBER_Member);
        UserDto  userDto =(UserDto)session.getAttribute(REMEBER_UserDto);
        //注销cookie
        Cookie autologincookie = new Cookie(REMEBER_AUTO_LOGIN,"");
        autologincookie.setMaxAge(-1);/*删除cookie*/
        resp.addCookie(autologincookie);
        //注销session
        session.invalidate();
        return "/login";
    }

}
