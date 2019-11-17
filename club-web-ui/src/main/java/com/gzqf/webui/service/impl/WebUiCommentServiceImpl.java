package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.CommentInfo;
import com.gzqf.club.entity.NewsPush;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.WebUiCommentService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WebUiCommentServiceImpl implements WebUiCommentService{


    @Override
    public List<CommentInfo> getComment() {
        String s = HttpClientUtils.get("http://localhost:8081/getComment");
        System.out.println(s);
        return JSON.parseObject(s,new TypeReference<List<CommentInfo>>(){});
    }

    @Override
    public NewsPush getPushId(int id) {
        Map<String,String> parms = new HashMap<>();
        String s = String.valueOf(id);
        parms.put("id",s);
        String push=HttpClientUtils.post("http://localhost:8081/getPushId",parms);
        return JSON.parseObject(push,NewsPush.class);
    }
}
