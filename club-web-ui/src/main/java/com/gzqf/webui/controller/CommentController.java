package com.gzqf.webui.controller;


import com.gzqf.club.entity.CommentInfo;
import com.gzqf.club.entity.NewsPush;
import com.gzqf.webui.service.WebUiCommentService;
import com.gzqf.webui.service.WebUiPushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private WebUiCommentService webUiCommentService;


    @RequestMapping(value = "/newsInformation/information")
    public String showNewsPush(int id,Model model){
       List<CommentInfo> commentList= webUiCommentService.getComment();
       NewsPush newsPushList=webUiCommentService.getPushId(id);
       model.addAttribute("commentList",commentList);
       model.addAttribute("newsPushList",newsPushList);
        return "/newsInformation/information";
    }


}
