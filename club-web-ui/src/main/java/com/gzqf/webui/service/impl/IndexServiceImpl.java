package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.Appcat;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.IndexService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexServiceImpl implements IndexService {
    @Override
    public List<Appcat> findAppcatAll() {
        String result= HttpClientUtils.get("http://localhost:8081/findAppcatAll");
        return JSON.parseObject(result,new TypeReference<List<Appcat>>(){});
    }
}
