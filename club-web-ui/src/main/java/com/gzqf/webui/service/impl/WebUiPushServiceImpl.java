package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.NewsPush;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.WebUiPushService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WebUiPushServiceImpl implements WebUiPushService {
    @Override
    public List<NewsPush> getPush() {
        String s = HttpClientUtils.get("http://localhost:8081/getPush");
        return JSON.parseObject(s,new TypeReference<List<NewsPush>>(){});
    }
}
