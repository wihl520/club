package com.gzqf.webui.controller;

import com.google.code.kaptcha.Constants;
import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.utils.RandomNumber;
import com.gzqf.webui.config.EmailConfig;
import com.gzqf.webui.service.LoginService;
import com.gzqf.webui.service.WebUiRegistService;
import org.apache.commons.mail.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegistMemberController {
    private  static  final  String REMEBER_Member = "member";
    private  static  final  String REMEBER_UserDto = "userDto";
    private  static  final  String REMEBER_Message = "message";


    @Autowired
    private WebUiRegistService webUiRegistService;

    @Autowired
    private LoginService loginService;

    //生成电子邮箱验证码存入UserDto对象session
    @RequestMapping(value = "getemailcode")
    public String Getemailcode(String newcode,String repassword,Member member,HttpServletRequest req){
        UserDto<Member> userDto = new UserDto<>();
        //取出密码
        String password = member.getPassword();
        //获取验证码
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        //验证用户是否存在或者验证码错误,密码是否一致
        userDto = webUiRegistService.verify(member,newcode,code,repassword);
        //放入密码
        member.setPassword(password);
        userDto.setVerificationcode(newcode);
        //可以注册发送电子邮件
        if (userDto.getStatus()==UserDto.SUCCESS_STATUS){
            //随机生成一个验证码
            String randomNumber = RandomNumber.randomNumber();
            userDto.setEmailcode(randomNumber);
            //发送电子邮件验证码
            try {
                //获取到电子邮件的对象
                Email email = EmailConfig.getEmail();
                //给其发送对象的邮箱地址赋值：user.getEmail()指的是用户的邮件地址
                email.addTo(member.getEmail());
                //标题
                email.setSubject("健身俱乐部");
                //内容 ：user.getUserName()指用户注册的用户名
                email.setMsg("尊敬的用户："+member.getName()+",你好，你在健身俱乐部的验证码为："+randomNumber+"，请注意使用！！！");
                //真正的发送
                email.send();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        session.setAttribute(REMEBER_Member,member);
        session.setAttribute(REMEBER_UserDto,userDto);
        return "member/regist";
    }

    //注册用户
    @RequestMapping(value = "regist",method = RequestMethod.POST)
    public String RegistRemember(Member member,String emailcode,HttpServletRequest req){
        HttpSession session = req.getSession();
        UserDto<Member> userDto = (UserDto<Member>) session.getAttribute(REMEBER_UserDto);
        //先判断是否发送电子邮箱验证
        userDto =webUiRegistService.verifyEmailCode(userDto,emailcode);
        //尚未发送验证码
        if (userDto.getStatus()==UserDto.FAIL_STATUS){
            session.setAttribute(REMEBER_Member,member);
            session.setAttribute(REMEBER_UserDto,userDto);
            return "member/regist";
        }
        else{
            userDto= webUiRegistService.registmember(member);
            session.setAttribute(REMEBER_Member,member);
            session.setAttribute(REMEBER_UserDto,userDto);
            session.setAttribute("message",userDto.getMessage());
            return "login";
        }


    }

}
