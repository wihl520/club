package com.gzqf.apitest;

import com.gzqf.club.entity.Member;
import com.gzqf.club.utils.RandomNumber;
import com.gzqf.clubapi.service.ApiLoginService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})

public class logintest {
    @Autowired
    private ApiLoginService loginService;

    @Test
    public void getByNameAndPassword(){
        Member member  = new Member();
        member.setName("weishengqin");
        member.setPassword("123456");
        Member byNameAndPassword = loginService.getByNameAndPassword(member);
        System.out.println(byNameAndPassword);
    }

    @Test
    public void Random(){
        String s = RandomNumber.randomNumber();
        System.out.println(s);
    }
}
