package com.gzqf.clubapi.controller;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.CommentInfo;
import com.gzqf.club.entity.NewsPush;
import com.gzqf.clubapi.service.CommentService;
import com.gzqf.clubapi.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CommentController {
    @Autowired
    private CommentService commentService;
    @Autowired
    private PushService pushService;

    @RequestMapping(value = "/getComment",method = RequestMethod.GET,produces = "application/json;charset=utf-8" )
    @ResponseBody
    public String getComment(){
        List<CommentInfo> listComment = commentService.getComment();
        return JSON.toJSONString(listComment);
    }

    @RequestMapping(value = "/getPushId",method = RequestMethod.POST,produces = "application/json;charset=utf-8" )
    @ResponseBody
    public  String  getPushId(String id){
       int id1=Integer.parseInt(id);
       NewsPush newsPush= pushService.getPushId(id1);
       return JSON.toJSONString(newsPush);
    }
}
