package com.gzqf.apitest;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.Result;
import com.gzqf.clubapi.service.ApiMemberRegistService;
import com.gzqf.clubapi.service.MemBerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class MemberServiceTest {

    @Autowired
    MemBerService memBerService;

    @Test
    public void updateMemberday(){
        Member member = memBerService.getById(2L);
        member.setMemberDay(member.getMemberDay()+30);
        Result update = memBerService.updateMemberday(member);
        System.out.println(update);
    }
}
