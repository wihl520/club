package com.gzqf.webui.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.gzqf.club.entity.Appcat;
import com.gzqf.club.entity.Member;
import com.gzqf.club.entity.NewsPush;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.utils.CookieUtils;
import com.gzqf.webui.service.IndexService;
import com.gzqf.webui.service.LoginService;
import com.gzqf.webui.service.WebUiPushService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.List;

/**
 * <p>Description: </p>
 * 验证码的显示模块
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 20:09
 **/
@Controller
public class IndexController {

    //3则重构 这是记住cookie名字
    private static final String REMEBER_AUTO_LOGIN = "memberautologin";
    private static final String REMEBER_Member = "member";
    private static final String REMEBER_UserDto = "userDto";
    private static final String REMEBER_Message = "message";


    @Autowired
    private Producer producer;

    @Autowired
    private LoginService loginService;
    @Autowired
    private IndexService indexService;

    @Autowired
    private WebUiPushService webUiPushService;

    //首页跳转
    @RequestMapping(value = {"", "index"})
    public String index(Model model) {
        List<NewsPush> listPush = webUiPushService.getPush();
        List<Appcat> list = indexService.findAppcatAll();
        model.addAttribute("appcatList", list);
        model.addAttribute("listPush", listPush);
        return "index";
    }

    //登录页的跳转
    @RequestMapping(value = "/membertologin", method = RequestMethod.GET)
    public String login(HttpServletResponse resp, HttpServletRequest req) {
        HttpSession session = req.getSession();
        String cookieValue = CookieUtils.getCookieValue(req, REMEBER_AUTO_LOGIN);
        //cookie为空直接去到登录页面
        if (StringUtils.isEmpty(cookieValue)) {
            return "/login";
        }

        UserDto<Member> userDto = loginService.queryUserDto(cookieValue);
        return RemeberOrAutologin(resp, req, session, userDto);

    }

    //跳转到注册页面
    @RequestMapping("/membertoregist")
    public String membertoregist() {
        return "member/regist";
    }


    //判断是什么记住密码操作还是自动登录操作
    private String RemeberOrAutologin(HttpServletResponse resp, HttpServletRequest req, HttpSession session, UserDto userDto) {
        if (userDto.getStatus() == UserDto.FAIL_STATUS) {
            //自动登录出错
            req.setAttribute(REMEBER_Message, userDto.getMessage());
            return "/login";
        }
        /*客户端保存记住自动登录cookie的情况下*/
        if (userDto != null) {
            return doautologin(req, resp, session, userDto);
        }
        /*客户端有cookie值时，但是没有用户登录的数据，默认跳转到登录页面*/
        else {
            session.setAttribute(REMEBER_UserDto, userDto);
            return "/login";
        }
    }

    //自动登录
    private String doautologin(HttpServletRequest req, HttpServletResponse resp, HttpSession session, UserDto userDto) {
        /*判断是否为自动登录*/
        if (userDto.isAutologin() == true) {
            /*自动登录*/
            //可以验证账号密码是否正确
            session.setAttribute(REMEBER_Member, userDto.getData());
            session.setAttribute(REMEBER_UserDto, userDto);
            Member member = (Member) userDto.getData();
            //给cookie加时间
            CookieUtils.setCookie(req, resp, REMEBER_AUTO_LOGIN, String.format("%s:%s:%s:%s", member.getName(), member.getPassword(), userDto.isRemember(), userDto.isAutologin()), 7 * 24 * 60 * 60);
            return "redirect:/index";
        }
        /*这个是保存密码但不是自动登录时，取出cookie的值并赋值显示*/
        else {
            //登录成功后的session
            session.setAttribute(REMEBER_UserDto, userDto);
            Member member1 = (Member) userDto.getData();
            session.setAttribute(REMEBER_Member, member1);
            return "/login";
        }
    }


    /**
     * 产生验证码
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/kaptcha")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        response.setDateHeader("Expires", 0);//过期时间（缓存时间）设置为0 0表示不缓存
        //清除缓存，禁止浏览器缓存图片
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        //设置返回数据类型是jpg
        response.setContentType("image/jpeg");
        //创建一个验证码
        String capText = producer.createText();
        //将验证码放到session里面
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        //画出图片
        BufferedImage bi = producer.createImage(capText);
        //输出
        OutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }
}
