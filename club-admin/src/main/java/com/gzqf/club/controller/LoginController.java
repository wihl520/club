package com.gzqf.club.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>Description: </p>
 * 登录模块
 *
 * @author Wenas
 * @version 1.0.0
 * @date 2019/11/17 14:09
 **/
@Controller
public class LoginController {
    /**
     * 登录请求为空时，直接跳转到登录页面
     *
     * @return 请求页面地址
     */
    @RequestMapping("")
    public String toLogin() {
        return "redirect:/admin/login";
    }

}
