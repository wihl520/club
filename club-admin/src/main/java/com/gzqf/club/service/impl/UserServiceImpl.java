package com.gzqf.club.service.impl;

import com.gzqf.club.dao.IUserDao;
import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.club.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserServiceImpl extends BaseServiceImpl<User,IUserDao> implements IUserService {


    //首先判断cookie是否有值.可能是空的cookie
    @Override
    public UserDto queryUserDto(String cookieValue) {
        //如果cookie有值时
        UserDto<User> userDto = new UserDto();
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
        User user = new User();
        user.setUserName(split[0]);
        user.setPassword(split[1]);
        //记住账号密码的
        if ("true".equals(split[2])){
            userDto.setRemember(true);
        }
        else{
            userDto.setRemember(false);
        }

        //自动登录的
        if ("true".equals(split[3])){
            userDto = adminlogin(user);
            //成功时重新修改其密码
            if (userDto.getStatus()==UserDto.SUCCESS_STATUS){
                userDto.setRemember(true);
                userDto.setAutologin(true);
                //存入的是查出的密码为空的对象，所以先把密码赋值回去,可能涉及密码加密
                user.setPassword(split[1]);
                userDto.setData(user);
            }
        }
        else{
            userDto.setAutologin(false);
        }
        userDto.setData(user);
        return userDto;
    }


    //账号密码的登录
    @Override
    public UserDto<User> adminlogin(User user) {
        UserDto<User> userDto =  new UserDto<>();
        String password = user.getPassword();
        //包括null 和空字符串的判断方法
        if (StringUtils.isBlank(user.getPassword())){
            /*修改Result的状态*/
           return userDto.fail("密码不能为空!");
        }
        /*使用加密方式*/
        password= DigestUtils.md5DigestAsHex(password.getBytes());
        User nowuser = dao.getByNameAndPassword(user.getUserName(), password);
        if(nowuser!=null){
            /*修改Result的状态*/
            return userDto.success("",user);
        }
//
//        if ("admin@qq.com".equals(user.getUserName())&&"123456".equals(user.getPassword())){
//            //虚拟数据返回
//            return userDto.success("",user);
//        }
        return userDto.fail("账号或密码错误！请重新登录...");
    }

    //验证码判断
    @Override
    public UserDto<User> VerificationCode(String verificationcode, String code,UserDto userDto) {
//        验证码是否正确
//         userDto = new UserDto<>();
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


}
