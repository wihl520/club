package com.gzqf.apitest;

import com.gzqf.club.entity.Appcat;
import com.gzqf.clubapi.service.ApiEquipmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class EquipmentTest {

    @Autowired
    private ApiEquipmentService apiEquipmentService;
    @Test
    public void Test1(){
        Appcat byId = apiEquipmentService.getById(1L);
        System.out.println(byId);
    }
}
