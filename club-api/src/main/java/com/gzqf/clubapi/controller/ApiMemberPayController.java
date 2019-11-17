package com.gzqf.clubapi.controller;

import com.gzqf.clubapi.service.ApiMemberPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ApiMemberPayController {

    @Autowired
    private ApiMemberPayService apiMemberPayService;


}
