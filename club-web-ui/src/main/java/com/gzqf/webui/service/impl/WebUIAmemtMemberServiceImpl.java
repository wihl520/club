package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.WebUIAmemtMemberService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class WebUIAmemtMemberServiceImpl implements WebUIAmemtMemberService {
    //修改密码操作
    @Override
    public UserDto<Member> amemdmemberpassword(Long id, String password, String newpassword) {
        Map<String,String> params = new HashMap<>();
        params.put("id",id.toString());
        params.put("password",password);
        params.put("newpassword",newpassword);
        //访问Api获取到数据UserDto<Member>
        String result = HttpClientUtils.post("http://localhost:8081/amemdmemberpassword", params);
        UserDto<Member> memberUserDto = JSON.parseObject(result, new TypeReference<UserDto<Member>>() {
        });
        return memberUserDto;
    }

    //修改用户操作
    @Override
    public UserDto<Member> amemt(Member member ,String sex) {
        Map<String,String> params = new HashMap<>();
        params.put("personid",member.getId().toString());
        params.put("pic",member.getPic());
        params.put("phone",member.getPhone());
        params.put("personsex",sex);
        params.put("wantBuild",member.getWantBuild());
        params.put("personage",member.getAge().toString());

        params.put("address",member.getAddress());
        //访问Api获取到数据UserDto<Member>
        String result = HttpClientUtils.post("http://localhost:8081/memberament", params);
        UserDto<Member> memberUserDto = JSON.parseObject(result, new TypeReference<UserDto<Member>>() {
        });
        return memberUserDto;
    }




}
