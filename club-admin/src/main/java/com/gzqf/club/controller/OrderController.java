package com.gzqf.club.controller;

import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.BaseController;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.service.OrderService;
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
public class OrderController extends BaseController<OrderService,Order> {

    @RequestMapping("/list")
    public String list(Page page, Model model){
        Order order = new Order();
        order.setPage(page);
        Result result = Service.pageList(order);
        model.addAttribute("list",((PageResult)result.getData()).getList());
        model.addAttribute("page",result.getData());
        return "order/list";
    }
    @RequestMapping("/delete")
    public String delete(String id, RedirectAttributes redirectAttributes){
        Long i = Long.parseLong(id);
        Service.delete(i);
        redirectAttributes.addAttribute("message","删除数据成功");
        return "redirect:/list";
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
        Order order = Service.getById(id);
        Date payDate = order.getPayDate();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String pay = simpleDateFormat.format(payDate);
        model.addAttribute("order",order);
        model.addAttribute("pay",pay);
        return "order/form";
    }
}
