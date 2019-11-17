package com.gzqf.apitest;

import com.gzqf.club.entity.*;
import com.gzqf.clubapi.service.ApiLoginService;
import com.gzqf.clubapi.service.ApiTipsService;
import com.gzqf.clubapi.service.CommentService;
import com.gzqf.clubapi.service.PushService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})

public class test {
    @Autowired
    private ApiLoginService loginService;
    @Autowired
    private CommentService commentService;
    @Autowired
    private PushService pushService;
    @Autowired
    private ApiTipsService apiTipsService;

    @Test
    public void getByNameAndPassword(){
        Member member  = new Member();
        member.setName("weishengqin");
        member.setPassword("123456");
        Member byNameAndPassword = loginService.getByNameAndPassword(member);
        System.out.println(byNameAndPassword);
    }
    @Test
    public void commentTest(){
        List<CommentInfo> c = commentService.getComment();
        System.out.println(c);
    }

    @Test
    public void pushId(){
        NewsPush n=pushService.getPushId(3);
        System.out.println(n);
    }
    @Test
    public void getlist(){
        List<Tips> list = apiTipsService.getTipsList(7L);
       /* System.out.println(list);*/
        Tips tip = apiTipsService.getTip(3L);
        System.out.println(tip);
    }
}
