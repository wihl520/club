package com.gzqf.club.intercepter;

import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.utlis.CusAccessObjectUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>Description: </p>
 * 登录拦截器
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 18:59
 **/
public class LoginIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object o) throws Exception {

        String ipAddress = CusAccessObjectUtil.getIpAddress(req);
        StringBuffer requestURL = req.getRequestURL();
        String contextPath = req.getContextPath();
        String method = req.getMethod();
        String pathInfo = req.getPathInfo();
        String servletPath = req.getServletPath();
        User user = (User) req.getSession().getAttribute("user");
        if (user == null) {
            resp.sendRedirect("/admin/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
