package com.gzqf.club.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.service.IUserService;
import com.gzqf.club.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.OutputStream;

/**
 * <p>Description: </p>
 * 后台用户模块
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:09
 **/
@Controller
@RequestMapping("/admin")
public class Usercontroller extends BaseController<IUserService, User> {

    // 3则重构 注意：只适合静态数据，不适合静态的对象，会引发线程问题
    // 这是记住cookie名字
    private static final String REMEBER_AUTO_LOGIN = "autologin";
    private static final String REMEBER_User = "user";
    private static final String REMEBER_UserDto = "userDto";
    private static final String REMEBER_Message = "message";

    @Autowired
    private Producer producer;

    /**
     * 登录页面的请求跳转
     *
     * @param resp 响应
     * @param req 请求
     * @return String
     */
    @RequestMapping(value = {"", "/login"}, method = RequestMethod.GET)
    public String admintologin(HttpServletResponse resp, HttpServletRequest req, User user) {
        HttpSession session = req.getSession();
        String cookieValue = CookieUtils.getCookieValue(req, REMEBER_AUTO_LOGIN);

        //cookie为空直接去到登录页面
        if (StringUtils.isEmpty(cookieValue)) {
            return "login";
        }
        UserDto<User> userDto = Service.queryUserDto(cookieValue);
        return remeberOrAutologin(resp, req, session, userDto);
    }

    /**
     * 判断是什么记住密码操作还是自动登录操作
     *
     * @param resp
     * @param req
     * @param session
     * @param userDto
     * @return
     */
    private String remeberOrAutologin(HttpServletResponse resp, HttpServletRequest req, HttpSession session, UserDto userDto) {
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

    /**
     * 自动登录
     *
     * @param req
     * @param resp
     * @param session
     * @param userDto
     * @return
     */
    private String doautologin(HttpServletRequest req, HttpServletResponse resp, HttpSession session, UserDto userDto) {
        /*判断是否为自动登录*/
        if (userDto.isAutologin() == true) {
            /*自动登录*/
            //可以验证账号密码是否正确
            session.setAttribute(REMEBER_User, userDto.getData());
            session.setAttribute(REMEBER_UserDto, userDto);
            User user = (User) userDto.getData();
            //给cookie加时间
            CookieUtils.setCookie(req, resp, REMEBER_AUTO_LOGIN, String.format("%s:%s:%s:%s", user.getUserName(), user.getPassword(), userDto.isRemember(), userDto.isAutologin()), 7 * 24 * 60 * 60);
            return "redirect:/admin/index";
        }
        /*这个是保存密码但不是自动登录时，取出cookie的值并赋值显示*/
        else {
            session.setAttribute(REMEBER_UserDto, userDto);
            User user1 = (User) userDto.getData();
            session.setAttribute(REMEBER_User, user1);
            return "/login";
        }
    }

    /**
     * 登陆
     * @param user
     * @param userDto
     * @param remember
     * @param autologin
     * @param model
     * @param req
     * @param resp
     * @return
     */
    @RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
    public String login(User user, UserDto userDto, String remember, String autologin, Model model, HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = (HttpSession) req.getSession();
        //验证码的判断
        //从session中取出验证码
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        userDto = Service.VerificationCode(userDto.getVerificationcode(), code, userDto);
        if (UserDto.FAIL_STATUS == userDto.getStatus()) {
            model.addAttribute(REMEBER_Message, userDto.getMessage());
            return "/login";
        }
        //用户账号密码判断是否正确
        userDto = Service.adminlogin(user);
        //当出错误时
        if (UserDto.FAIL_STATUS == userDto.getStatus()) {
            model.addAttribute(REMEBER_Message, userDto.getMessage());
            return "/login";
        } else {
            //使用userdto对象存储数据
            doremember(remember, autologin, userDto);
            /*如果有确认或者保存*/
            if (userDto.isAutologin() || userDto.isRemember()) {
                CookieUtils.setCookie(req, resp, REMEBER_AUTO_LOGIN, String.format("%s:%s:%s:%s", user.getUserName(), user.getPassword(), userDto.isRemember(), userDto.isAutologin()), 7 * 24 * 60 * 60);
            } else {
//                设置为过期
//                Cookie autologincookie = new Cookie(REMEBER_AUTO_LOGIN,"");
//                autologincookie.setMaxAge(-1);/*删除cookie*/
//                resp.addCookie(autologincookie);
                CookieUtils.setCookie(req, resp, REMEBER_AUTO_LOGIN, String.format("%s:%s:%s:%s", user.getUserName(), user.getPassword(), userDto.isRemember(), userDto.isAutologin()), -1);
            }
            //将对象存到session里面
            user = (User) userDto.getData();
            session.setAttribute(REMEBER_User, user);
            session.setAttribute(REMEBER_UserDto, userDto);
            //重定向
            return "redirect:/admin/index";
        }

    }

    /**
     * 是否记住或者自动登录的对象赋值
     *
     * @param remember
     * @param autologin
     * @param userDto
     */
    private void doremember(String remember, String autologin, UserDto userDto) {
        if ("on".equals(remember)) {
            userDto.setRemember(true);
        } else {
            userDto.setRemember(false);
        }
        if ("on".equals(autologin)) {
            userDto.setAutologin(true);
        } else {
            userDto.setAutologin(false);
        }
    }

    /**
     * 注销用户操作
     *
     * @param req
     * @param resp
     * @param session
     * @return
     */
    @RequestMapping("/LogoutUser")
    public String LogoutUser(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        User user = (User) session.getAttribute(REMEBER_User);
        UserDto<User> userDto = (UserDto) session.getAttribute(REMEBER_UserDto);
        //注销cookie
        Cookie autologincookie = new Cookie(REMEBER_AUTO_LOGIN, "");
        autologincookie.setMaxAge(-1);/*删除cookie*/
        resp.addCookie(autologincookie);
        //注销session
        session.invalidate();
        return "/login";
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
        response.setContentType("image/jpeg");//设置返回数据类型是jpg
        String capText = producer.createText();//创建一个验证码
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);//将验证码放到session里面
        BufferedImage bi = producer.createImage(capText);//画出图片
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
