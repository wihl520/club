package com.gzqf.webui.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.gzqf.club.entity.Member;
import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.utils.HttpClientUtils;
import com.gzqf.webui.service.LoginService;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.HashMap;
import java.util.Map;



@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public UserDto<Member> queryUserDto(String cookieValue) {
//        如果cookie有值时
        UserDto<Member> userDto = new UserDto();
        String[] split = cookieValue.split(":");
        if (split.length > 0){
            return getUserDtoCookie(userDto, split);
        }
        //没有cookie的情况
        else {
            return null;
        }
    }
    //对cookie的值进行判断
    private UserDto getUserDtoCookie(UserDto userDto, String[] split) {

            Member member = new Member();
            member = new Member();
            member.setName(split[0]);
            member.setPassword(split[1]);
            //记住账号密码的
            if ("true".equals(split[2])) {
                userDto.setRemember(true);
            } else {
                userDto.setRemember(false);
            }
            //自动登录的
            if ("true".equals(split[3])){
                userDto = adminlogin(member);
                //成功时重新修改其密码
                if (userDto.getStatus() == UserDto.SUCCESS_STATUS) {
                    userDto.setRemember(true);
                    userDto.setAutologin(true);
                    //存入的是查出的密码为空的对象，所以先把密码赋值回去,可能涉及密码加密
                    member.setPassword(split[1]);
                    Member data = (Member) userDto.getData();
                    data.setPassword(member.getPassword());
                    userDto.setData(data);
                }
            } else {
                userDto.setAutologin(false);
            }
            userDto.setData(member);
            return userDto;
    }

    //账号密码的登录
    public UserDto<User> adminlogin(Member member) {
        UserDto<Member> userDto =  new UserDto<>();
        String password = member.getPassword();
        //包括null 和空字符串的判断方法
        if (StringUtils.isBlank(member.getPassword())){
            /*修改Result的状态*/
            return userDto.fail("密码不能为空!");
        }

        //将数据放入map中，进行远程访问；
        Map<String,String> params = new HashMap<>();
        params.put("name",member.getName());
        params.put("password",member.getPassword());
        //访问Api获取到数据UserDto<Member>
        String result = HttpClientUtils.post("http://localhost:8081/uilogin", params);
        UserDto<Member> memberUserDto = JSON.parseObject(result, new TypeReference<UserDto<Member>>() {
        });

        if(memberUserDto.getStatus()==UserDto.SUCCESS_STATUS){
            /*修改UserDto的状态*/
            Member memberUserDtoData = memberUserDto.getData();
            memberUserDtoData.setPassword(member.getPassword());
            return userDto.success("",memberUserDtoData);
        }
        return userDto.fail("账号或密码错误！请重新登录...");
    }

    //验证码判断
    public UserDto<User> VerificationCode(String verificationcode, String code,UserDto userDto) {
//        验证码是否正确
        if (StringUtils.isBlank(verificationcode)){
            userDto = userDto.fail("验证码不能为空！！！");
        }

        if (!StringUtils.equalsIgnoreCase(verificationcode,code)){
            userDto = userDto.fail("验证码不正确！！！");
        }
        else{
            userDto = userDto.success("",userDto);
        }
        return userDto;
    }


    @Override
    public Result<User> checkUser(User user) {
        //登录表单提交参数的非空验证
        if(user == null){
            return Result.fail("用户名及密码不能为空！");
        }
        if(StringUtils.isBlank(user.getUserName())){
            return Result.fail("用户名不能为空！");
        }
        if(StringUtils.isBlank(user.getPassword())){
            return Result.fail("用户密码不能为空！");
        }
        //将数据放入map中，进行远程访问；
        Map<String,String> params = new HashMap<>();
        params.put("userName",user.getUserName());
        params.put("password",user.getPassword());
        //访问Api
        String result = HttpClientUtils.post("http://localhost:8081/uilogin", params);
        return JSON.parseObject(result,new TypeReference<Result<User>>(){});
    }
}
