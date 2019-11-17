package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.Appcat;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.WebEquipmentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebEquipmentServiceImpl implements WebEquipmentService {

    @Override
    public Result getEquipmentInfo(String id){

        Map<String, String> param = new HashMap<>();
        param.put("id",id);
        String url="http://127.0.0.1:8081/getEquipmentInfo";
        String equipmentMessage = HttpClientUtils.post(url, param);
        return JSON.parseObject(equipmentMessage,new TypeReference<Result<Appcat>>(){});
    }
}
