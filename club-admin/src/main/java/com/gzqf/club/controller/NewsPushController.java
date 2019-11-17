package com.gzqf.club.controller;

import com.gzqf.club.entity.NewsPush;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.impl.NewsPushServiceImpl;
import com.gzqf.club.web.support.Page;
import com.gzqf.club.web.support.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
@RequestMapping("/newspush")
public class NewsPushController extends BaseController<NewsPushServiceImpl, NewsPush> {
    @RequestMapping(value = "/list" )
    public String toList(NewsPush newsPush, Page page, Model model, @ModelAttribute("message") String message){
        newsPush.setPage(page);
        Result result = Service.pageList(newsPush);
        model.addAttribute("list",((PageResult<NewsPush>)result.getData()).getList());
        //使用自定义标签库，显示分页
        model.addAttribute("page",(PageResult<NewsPush>)result.getData());
        model.addAttribute("message",message);
        return "/newspush/list";
    }

    @RequestMapping("/form")
    public String toForm(Long id, Model model, @ModelAttribute("errorMessage")String errorMessage, @ModelAttribute("appcat") NewsPush newsPush1){
        //带有ID的跳转为修改操作，需进行数据回显
        if(newsPush1 != null){
            model.addAttribute("newsPush",newsPush1);
        }
        if(id != null && id.longValue() > 0){
            NewsPush newsPush = Service.getById(id);
            model.addAttribute("newsPush",newsPush);
        }
        model.addAttribute("errorMessage",errorMessage);
        return "/newspush/form";
    }

    //器材分类的编辑(含新增及添加功能)
    @RequestMapping("/edit")
    public String edit(NewsPush newsPush, Model model, RedirectAttributes redirectAttributes){
        Result result = null;
        //依据参数是否有ID判断是新增还是修改
        if(newsPush.getId() != null && newsPush.getId().longValue() > 0){
            result = Service.update(newsPush);
        }
        //ID存在，为编辑修改
        else{
            newsPush.setNewsDate(new Date());
            result = Service.save(newsPush);
        }
        if(Result.SUCCESS_STATUS == result.getStatus()){
            redirectAttributes.addFlashAttribute("message","数据更新成功！");
            return "redirect:/newspush/list";
        }
        redirectAttributes.addFlashAttribute("errorMessage",result.getMessage());
        return "redirect:/newspush/form";
    }

    //删除数据
    @RequestMapping(value = "/delete")
    public String delete(Long id,RedirectAttributes redirectAttributes){
        Result result = Service.delete(id);
        if(Result.SUCCESS_STATUS == result.getStatus()){
            redirectAttributes.addFlashAttribute("message","删除数据成功！");
        }else{
            redirectAttributes.addFlashAttribute("failMessage","删除数据失败！");
        }
        return "redirect:/newspush/list";
    }
}
