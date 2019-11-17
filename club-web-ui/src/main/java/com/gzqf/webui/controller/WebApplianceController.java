package com.gzqf.webui.controller;

import com.gzqf.club.entity.Appliance;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.web.support.Page;
import com.gzqf.club.web.support.PageResult;
import com.gzqf.webui.service.WebApplianceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebApplianceController {

    @Autowired
    private WebApplianceService webApplianceService;
    @RequestMapping("/list")
    public String list(String categoryId, Page page, Model model){
        Result<PageResult<Appliance>> result = webApplianceService.getAllApplianceInfo(page,categoryId);
        model.addAttribute("result",result.getData().getList());
        model.addAttribute("page",result.getData());
        model.addAttribute("categoryId",categoryId);
        return "equip/list";
    }

    @RequestMapping("/use")
    public String userById(String id,String memberId,String categoryId,Page page, Model model){
        webApplianceService.userById(id,memberId);
        return list(categoryId,page,model);
    }
    @RequestMapping("/back")
    public String backById(String id,String categoryId,Page page, Model model){
        webApplianceService.backById(id);
        return list(categoryId,page,model);
    }

}
