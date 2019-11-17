package com.gzqf.apitest;

import com.gzqf.club.entity.Member;
import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.Result;
import com.gzqf.clubapi.service.MemBerService;
import com.gzqf.clubapi.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class OrderServiceTest {

    @Autowired
    MemBerService memBerService;

    @Autowired
    OrderService orderService;

    @Test
    public void updateMemberday(){
        Member member = memBerService.getById(2L);
        member.setMemberDay(member.getMemberDay()+30);

        /*添加订单表 - 失败*/
        Order order = new Order();
        order.setPayAmount(30);
        order.setPayWay("微信");
        order.setMemberId(member.getId().intValue());
        order.setPayDate(new Date());
        order.setTotalDay(30);
        Result saveresult = orderService.save(order);
        System.out.println(saveresult);
    }
}
