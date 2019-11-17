package com.gzqf.clubapi.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.Appcat;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.Result;
import com.gzqf.clubapi.service.ApiEquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiEquipmentController extends BaseController<ApiEquipmentService,Appcat> {



    @RequestMapping(value = "/getEquipmentInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getEquipmentInfo(String id){
        Long l = Long.parseLong(id);
        Appcat appCat = Service.getById(l);

        if(appCat!=null){
            return JSON.toJSONString(Result.success("",appCat));
        }else{
            return "";
        }
    }

}
