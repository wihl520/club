package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.WebUiRegistService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WebUiRegistServiceImpl implements WebUiRegistService {

    //private UserDto<Member> userDto;
    //验证电子邮箱的验证码是否一致
    @Override
    public UserDto<Member> verifyEmailCode(UserDto<Member> userDto, String emailcode) {
        Member data = userDto.getData();
        if (!userDto.getEmailcode().equals(emailcode)){
            userDto = UserDto.fail("验证码错误，请重新输入！！！");
            userDto.setData(data);
            return userDto;
        }
        else{
            userDto = UserDto.success("恭喜你注册成功！赶紧登录体验！",userDto.getData());
            return userDto;
        }

    }

    //注册
    @Override
    public UserDto<Member> registmember(Member member) {

        Map<String,String> params = new HashMap<>();
        params.put("name",member.getName());
        params.put("password",member.getPassword());
        params.put("email",member.getEmail());
        //访问Api获取到数据UserDto<Member>
        String result = HttpClientUtils.post("http://localhost:8081/registmember", params);
        UserDto<Member> memberUserDto = JSON.parseObject(result, new TypeReference<UserDto<Member>>() {
        });
        return memberUserDto;

    }
    //验证是否能注册
    @Override
    public UserDto<Member> verify(Member member, String newcode, String code,String repassword) {
        UserDto<Member> userDto ;
        //密码不一致的时候
        if (!repassword.equals(member.getPassword())){
            userDto = UserDto.fail("密码不一致，请重新确认！！！");
            return userDto;
        }
        //验证码不正确的时候
        if (!StringUtils.equalsIgnoreCase(newcode,code)){
            userDto = UserDto.fail("验证码不正确，请重新输入！！！");
            return userDto;
        }
        //验证用户名和电子邮箱是否注册//将数据放入map中，进行远程访问
        Map<String,String> params = new HashMap<>();
        params.put("name",member.getName());
        params.put("email",member.getEmail());
        //访问Api获取到数据UserDto<Member>
        String result = HttpClientUtils.post("http://localhost:8081/verifymember", params);
        UserDto<Member> memberUserDto = JSON.parseObject(result, new TypeReference<UserDto<Member>>() {
        });
        return memberUserDto;
    }
}
