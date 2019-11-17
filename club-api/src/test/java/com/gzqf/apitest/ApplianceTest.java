package com.gzqf.apitest;

import com.gzqf.club.entity.Appcat;
import com.gzqf.club.entity.Appliance;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.web.support.Page;
import com.gzqf.clubapi.service.ApiApplianceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class ApplianceTest {

    @Autowired
    private ApiApplianceService apiApplianceService;
    @Test
    public void Test01(){
        Appliance appliance = new Appliance();
        Appcat appcat = new Appcat();
        appcat.setId(4L);
        appliance.setParent(appcat);
       Result list = apiApplianceService.findList(appliance);
        System.out.println(list);
    }

    @Test
    public void Test02(){
        Appliance appliance = new Appliance();
        Page page = new Page();
        Appcat appcat = new Appcat();
        appcat.setId(4L);
        appliance.setPage(page);
        appliance.setParent(appcat);
        Result result = apiApplianceService.pageList(appliance);
        System.out.println(result.getData());
    }
}
