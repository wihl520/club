package com.gzqf.clubapi.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.Appcat;
import com.gzqf.club.entity.Appliance;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.web.support.Page;
import com.gzqf.clubapi.service.ApiApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

;

@Controller
public class ApiApplianceController extends BaseController<ApiApplianceService,Appliance> {

    @Autowired
    private ApiApplianceService apiApplianceService;
   /* @RequestMapping(value = "/getAllApplianceInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllApplianceInfo(String categoryId) {
        long l = Long.parseLong(categoryId);
        Appliance appliance = new Appliance();
        Appcat appcat = new Appcat();
        appcat.setId(l);
        appliance.setParent(appcat);
        Result applianceList = Service.findList(appliance);
        if (applianceList != null) {
            return JSON.toJSONString(appliancelist);
        } else {
            return "";
        }
    }*/

    @RequestMapping(value = "/getAllApplianceInfo",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String getAllApplianceInfo(String categoryId,String current) {
        long l = Long.parseLong(categoryId);
        int i = Integer.parseInt(current);
        Appliance appliance = new Appliance();
        Appcat appcat = new Appcat();
        Page page = new Page();
        appcat.setId(l);
        page.setCurrent(i);
        appliance.setParent(appcat);
        appliance.setPage(page);
        Result result = Service.pageList(appliance);
        if (result != null) {
            return JSON.toJSONString(result);
        } else {
            return "";
        }
    }

    @RequestMapping(value = "/use",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void useById(String id,String memberId) {
        Long Id = Long.parseLong(id);
        Long userId = Long.parseLong(memberId);
        apiApplianceService.useById(userId,Id);
    }

    @RequestMapping(value = "/back",produces = "application/json;charset=utf-8")
    @ResponseBody
    public void backById(String id) {
        Long Id = Long.parseLong(id);
        apiApplianceService.backById(Id);
    }
}
