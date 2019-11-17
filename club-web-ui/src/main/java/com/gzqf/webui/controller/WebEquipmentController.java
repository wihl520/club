package com.gzqf.webui.controller;

import com.gzqf.club.persistence.Result;
import com.gzqf.webui.service.WebEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebEquipmentController {

    @Autowired
   private WebEquipmentService webEquipmentService;

    @RequestMapping("/equipment")
    public String equipment(String id,Model model){

        Result equipmentInfo = webEquipmentService.getEquipmentInfo(id);
        model.addAttribute("result",equipmentInfo);
        return "equip/equipment";
    }

    //教练招聘页跳转
    @RequestMapping(value = "/jlzp")
    public String jiaolianzhaoping(){
        return "/jlzp";
    }

}
