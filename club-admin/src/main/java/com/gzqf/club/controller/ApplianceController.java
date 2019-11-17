package com.gzqf.club.controller;

import com.gzqf.club.entity.ApplianceAdmin;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.impl.ApplianceServiceImpl;
import com.gzqf.club.web.support.Page;
import com.gzqf.club.web.support.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/appliance")
public class ApplianceController extends BaseController<ApplianceServiceImpl,ApplianceAdmin> {
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String toApplianceList(ApplianceAdmin applianceAdmin, Page page, Model model){

        applianceAdmin.setPage(page);
        Result result = Service.pageList(applianceAdmin);
        model.addAttribute("list",((PageResult<ApplianceAdmin>)result.getData()).getList());
        //使用自定义标签库，显示分页
        model.addAttribute("page",(PageResult<ApplianceAdmin>)result.getData());
//        model.addAttribute("message",message);
        return "/appliance/list";
    }

    @RequestMapping("/form")
    public String toForm(Long id, Model model, @ModelAttribute("errorMessage")String errorMessage, @ModelAttribute("appliance") ApplianceAdmin applianceAdmin1){
        //带有ID的跳转为修改操作，需进行数据回显
        if(applianceAdmin1 != null){
            model.addAttribute("applianceAdmin", applianceAdmin1);
        }
        if(id != null && id.longValue() > 0){
            ApplianceAdmin applianceAdmin = Service.getById(id);
            model.addAttribute("applianceAdmin", applianceAdmin);
        }
        model.addAttribute("errorMessage",errorMessage);
        return "/appliance/form";
    }

    //器材分类的编辑(含新增及添加功能)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    public String edit(ApplianceAdmin applianceAdmin, Model model, RedirectAttributes redirectAttributes){
        Result result = null;
        //依据参数是否有ID判断是新增还是修改
        if(applianceAdmin.getId() != null && applianceAdmin.getId().longValue() > 0){
            result = Service.update(applianceAdmin);
        }
        //ID存在，为编辑修改
        else{
            result = Service.save(applianceAdmin);
        }
        if(Result.SUCCESS_STATUS == result.getStatus()){
            redirectAttributes.addFlashAttribute("message",result.getMessage());
            return "redirect:/appliance/list";
        }
        redirectAttributes.addFlashAttribute("errorMessage",result.getMessage());
        return "redirect:/appliance/form";
    }

    //仅能删除无子节点的数据
    @RequestMapping(value = "/delete")
    public String delete(Long id,RedirectAttributes redirectAttributes){
        Result result = Service.delete(id);
        if(Result.SUCCESS_STATUS == result.getStatus()){
            redirectAttributes.addFlashAttribute("message","删除数据成功！");
        }else{
            redirectAttributes.addFlashAttribute("failMessage","删除数据失败！");
        }
        return "redirect:/appliance/list";
    }
}
