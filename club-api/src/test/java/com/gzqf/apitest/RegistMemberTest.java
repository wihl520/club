package com.gzqf.apitest;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.clubapi.service.ApiMemberRegistService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class RegistMemberTest {

    @Autowired
    ApiMemberRegistService apiMemberRegistService;

    @Test
    public  void verify(){
        Member member = new Member();
        member.setName("admi1@qq.com");
        member.setEmail("2635165365@qq.com");
        Date date = new Date();
        System.out.println(date);
        UserDto<Member> verifymember = apiMemberRegistService.verifymember(member);
        System.out.println(verifymember);
    }

    @Test
    public void regist(){
        Member member = new Member();
        member.setName("bdmi1@qq.com");
        member.setPassword("123456");
        member.setEmail("2635165364@qq.com");
        UserDto<Member> registmember = apiMemberRegistService.registmember(member);
        System.out.println(registmember);
    }

    @Test
    public void update(){
        Member member = new Member();
        member.setId(6L);
        member.setName("bdmi1@qq.com");
        member.setSex(0);
        member.setAddress("广西钦州");
        member.setPhone("18877544060");
        member.setPassword("123456");
        UserDto<Member> registmember = apiMemberRegistService.memberament(member,"男");
        System.out.println(registmember);
    }

    @Test
    public  void amendpasswordTest(){
        String id = "3";
        String password = "123456";
        String newpassword="666666";
        UserDto<Member> amemdmemberpassword = apiMemberRegistService.amemdmemberpassword(id, password, newpassword);
        System.out.println(amemdmemberpassword);
    }
}
