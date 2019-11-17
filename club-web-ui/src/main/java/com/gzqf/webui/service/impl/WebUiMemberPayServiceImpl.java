package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.gzqf.club.entity.NewsPush;
import com.gzqf.club.entity.Order;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.WebUiMemberPayService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebUiMemberPayServiceImpl implements WebUiMemberPayService {


    @Override
    public Order pay(Order order) {
        Map<String,String> parms = new HashMap<>();
        parms.put("id",Long.toString(order.getMemberId()));
        parms.put("totalDay",Integer.toString(order.getTotalDay()));
        parms.put("payAmount",Integer.toString(order.getPayAmount()));
        parms.put("payWay",order.getPayWay());
        String post = HttpClientUtils.post("http://localhost:8081/member/changeforms", parms);
        if (post != null){
            return order;
        }
        else{
            return null;
        }
    }
}
