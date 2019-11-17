package com.gzqf.club.intercepter;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Description: </p>
 * Spring 拦截器
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:57
 **/
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 判断session是否登录
     *
     * @param req  请求
     * @param resp 响应
     * @param o    对象
     * @return boolean
     * @throws Exception 异常
     */
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {
        HttpSession session = req.getSession();
        Object user = session.getAttribute("userDto");
        if (user != null) {
            // 已经登录
            return true;
        } else {
            // 重定向“/”默认为跳转到首页
            resp.sendRedirect("/");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
