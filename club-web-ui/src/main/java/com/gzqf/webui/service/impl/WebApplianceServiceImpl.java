package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.Appliance;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.club.web.support.Page;
import com.gzqf.club.web.support.PageResult;
import com.gzqf.webui.service.WebApplianceService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebApplianceServiceImpl implements WebApplianceService {
    @Override
    public Result<PageResult<Appliance>> getAllApplianceInfo(Page page, String categoryId) {
        HashMap<String, String> param = new HashMap<>();
        param.put("categoryId", categoryId);
        param.put("current",String.valueOf(page.getCurrent()));
        String url="http://127.0.0.1:8081/getAllApplianceInfo";
        String equipmentMessage = HttpClientUtils.post(url, param);
        Result<PageResult<Appliance>> listResult = JSON.parseObject(equipmentMessage, new TypeReference<Result<PageResult<Appliance>>>() {
        });
        //return listResult;
        return listResult;

    }

    @Override
    public void userById(String id, String memberId) {
        Map<String,String> params = new HashMap<>();
        params.put("id",id);
        params.put("memberId",memberId);
        //访问Api获取到数据UserDto<Member>
        HttpClientUtils.post("http://localhost:8081/use", params);
    }

    @Override
    public void backById(String id) {
        Map<String,String> params = new HashMap<>();
        params.put("id",id);
        HttpClientUtils.post("http://localhost:8081/back", params);
    }

}
