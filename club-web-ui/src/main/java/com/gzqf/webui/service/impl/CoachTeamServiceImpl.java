package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.Member;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.CoachTeamService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoachTeamServiceImpl implements CoachTeamService {
    @Override
    public List<Member> findList() {
        String result= HttpClientUtils.get("http://localhost:8081/findList");
        return JSON.parseObject(result,new TypeReference<List<Member>>(){});
    }

    @Override
    public Member findCoachById(String id) {
        Map<String,String> params = new HashMap<>();
        params.put("id",id);
        String result= HttpClientUtils.post("http://localhost:8081/findcoachInfo", params);
        return JSON.parseObject(result,new TypeReference<Member>(){});
    }

    @Override
    public List<Member> findStuList(String id) {
        Map<String,String> params = new HashMap<>();
        params.put("id",id);
        String result= HttpClientUtils.post("http://localhost:8081/findStuList", params);
        return JSON.parseObject(result,new TypeReference<List<Member>>(){});
    }
}
