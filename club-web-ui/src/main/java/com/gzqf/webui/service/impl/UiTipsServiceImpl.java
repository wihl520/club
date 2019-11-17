package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.Tips;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.UiTipsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UiTipsServiceImpl implements UiTipsService {
    @Override
    public List<Tips> getTipsList(Long id) {
        Map<String,String> parm = new HashMap<>();
        String idToS = String.valueOf(id);
        parm.put("id",idToS);
        String result = HttpClientUtils.post("http://localhost:8081/tip/getTipsList",parm);
        return JSON.parseObject(result, new TypeReference<List<Tips>>(){});
    }

    @Override
    public Tips getTip(Long id) {
        Map<String,String> parm = new HashMap<>();
        String idToS = String.valueOf(id);
        parm.put("id",idToS);
        String result = HttpClientUtils.post("http://localhost:8081/tip/getTip",parm);
        return JSON.parseObject(result,Tips.class);
    }
}
