package com.gzqf.club.controller;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.MemBerService;
import com.gzqf.club.web.support.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController extends BaseController<MemBerService, Member> {
    //userService = 父类service呢？
    @RequestMapping("/list")
    public String userlist(Member member, Page page, Model model, @ModelAttribute("message")String messsage){
        member.setPage(page);
        //这是不是刚才的分页查询的方法
        //service指的是UserService

        Result result=Service.pageList(member);

        model.addAttribute("message",messsage);
        model.addAttribute("result",result);
        model.addAttribute("member",member);
        return "member/list";
    }
    //编辑用户信息回显
    @RequestMapping("/from")
    public String userForm(Long id,Model model){
        Member member=Service.getById(id);
        model.addAttribute("member",member);
        return "/member/from";
    }

    @RequestMapping("/edit")
    public String userEdit(Member member, RedirectAttributes redirectAttributes, Model model){
        Result result=null;

        if(member.getId()!=null && member.getId()>0){
            result=Service.update(member);
        }else {
            result=Service.save(member);
        }

        if(result.getStatus()== Result.ERROR_STATUS){
            model.addAttribute("errorMessage",result.getMessage());
            return "/member/from";
        }
        redirectAttributes.addFlashAttribute("message","编辑用户成功！！");
        return "redirect:/member/list";
    }
    @RequestMapping("/delete")
    public String deleteUser(Long id, RedirectAttributes redirectAttributes){
        Service.delete(id);
        redirectAttributes.addFlashAttribute("message","删除用户成功！");
        return "redirect:/member/list";
    }

    @RequestMapping("/deleteMutil")
    @ResponseBody
    public String deleteMutil(String ids){
        if(ids!=null) {
            String[] idArray = ids.split(",");
            List<String> list=new ArrayList<>();
            for(String s:idArray){
                if(s!=null && s.trim().length()>0) {
                    list.add(s);
                }
            }
            Service.deleteMutil(list);
        }
        return "success";
    }

    @RequestMapping(value = "detail",method = RequestMethod.GET)
    public String detail(Member member, Model model){
        member=Service.getById(member.getId());
        model.addAttribute("member",member);
        return "member/detail";
    }

}
