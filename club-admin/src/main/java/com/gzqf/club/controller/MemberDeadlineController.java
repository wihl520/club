package com.gzqf.club.controller;

import com.gzqf.club.entity.MemberDeadline;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.MemberDeadlineService;
import com.gzqf.club.web.support.Page;
import com.gzqf.club.web.support.PageResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/deadline")
public class MemberDeadlineController extends BaseController<MemberDeadlineService,MemberDeadline> {

    @RequestMapping("/list")
    public String list(Page page, Model model) {
        MemberDeadline memberDeadline = new MemberDeadline();
        memberDeadline.setPage(page);
        Result result = Service.pageList(memberDeadline);
        model.addAttribute("list", ((PageResult) result.getData()).getList());
        model.addAttribute("page", result.getData());
        return "deadline/list";
    }

    @RequestMapping("/delete")
    public String delete(String id, RedirectAttributes redirectAttributes){
        Long i = Long.parseLong(id);
        Service.delete(i);
        redirectAttributes.addAttribute("message","删除数据成功");
        return "redirect:/deadline/list";
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

    @RequestMapping("/form")
    public String update(Long id,Model model){
        MemberDeadline deadline = Service.getById(id);
        Date registDate = deadline.getRegistDate();
        Date beginDate = deadline.getBeginDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String regist = simpleDateFormat.format(registDate);
        String begin = simpleDateFormat.format(beginDate);
        model.addAttribute("deadline",deadline);
        model.addAttribute("regist",regist);
        model.addAttribute("begin",begin);
        return "deadline/form";
    }

    @RequestMapping("/update")
    public String updateForm(MemberDeadline memberDeadline, RedirectAttributes redirectAttributes){
        Result deadline = Service.update(memberDeadline);
        redirectAttributes.addAttribute("deadline",deadline);
        return "redirect:/deadline/list";
    }

}
