package com.gzqf.webui.controller;

import com.gzqf.club.entity.Tips;
import com.gzqf.webui.service.UiTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "tips")
public class UiTipsController {
    @Autowired
    private UiTipsService uiTipsService;

    @RequestMapping(value = "main",method = RequestMethod.GET)
    public String tipsMain(){
        return "tips/tips";
    }

    @RequestMapping(value = "towanshenjie",method = RequestMethod.GET)
    public String toWanshen(){
        return "tips/category/wanshen";
    }
    @RequestMapping(value = "tobanka",method = RequestMethod.GET)
    public String toBanka(){
        return "tips/category/banka";
    }


    @RequestMapping(value = "yingyang",method = RequestMethod.GET)
    public String getNutri(Model model){
        List<Tips> tipsList = uiTipsService.getTipsList(7L);
        model.addAttribute("list",tipsList);
        return "tips/category/yingyang";
    }

    @RequestMapping(value = "goByTipId",method = RequestMethod.GET)
    public String goByTipId(Long id,Model model){
        Tips tip = uiTipsService.getTip(id);
        model.addAttribute("tip",tip);
        return "tips/category/detail";
    }

    @RequestMapping(value = "tip",method = RequestMethod.GET)
    public String getTip(Model model){
        List<Tips> tipsList = uiTipsService.getTipsList(8L);
        model.addAttribute("list",tipsList);
        return "tips/category/tip";
    }

    @RequestMapping(value = "plan",method = RequestMethod.GET)
    public String getPlan(Model model){
        List<Tips> tipsList = uiTipsService.getTipsList(9L);
        model.addAttribute("list",tipsList);
        return "tips/category/plan";
    }

}
