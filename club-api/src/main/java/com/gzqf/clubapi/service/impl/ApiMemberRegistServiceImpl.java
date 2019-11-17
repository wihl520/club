package com.gzqf.clubapi.service.impl;

import com.gzqf.club.entity.Member;
import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.persistence.UserDto;
import com.gzqf.clubapi.dao.ApiMemberRegistDao;
import com.gzqf.clubapi.service.ApiMemberRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class ApiMemberRegistServiceImpl extends BaseServiceImpl<Member,ApiMemberRegistDao> implements ApiMemberRegistService {

    @Autowired
    private ApiMemberRegistDao apiMemberRegistDao;



    //修改用户信息
    @Override
    public UserDto<Member> memberament(Member member,String sex) {
        //修改时间的更替
         Date date = new Date();
        member.setUpdated(date);
        member.setSex(IsSex(sex));
        apiMemberRegistDao.update(member);
        Member memberName = apiMemberRegistDao.getById(member.getId());
        return UserDto.success("修改个人信息成功！！",memberName);
    }
    //修改密码操作
    @Override
    public UserDto<Member> amemdmemberpassword(String id, String password, String newpassword) {
        Long loginid = Long.parseLong(id);
        UserDto<Member> userDto ;
        String digestAsHex = DigestUtils.md5DigestAsHex(password.getBytes());
        Member byIdAndPassword = dao.getIdAndPassword(loginid,digestAsHex);
        //用id和加密的密码查询
        if (byIdAndPassword==null){
            userDto = UserDto.fail("原密码不正确，请重新确认！！！");
        }
        else{
            //修改操作
            dao.updatepassword(loginid, DigestUtils.md5DigestAsHex(newpassword.getBytes()));
            userDto = UserDto.success("修改用户密码成功，请重新登录！！1",byIdAndPassword);
        }
        return  userDto;
    }

    //注册用户
    @Override
    public UserDto<Member> registmember(Member member) {
        UserDto<Member> userDto;
        //时间创建
        Date date = new Date();
        member.setCreated(date);
        member.setUpdated(date);
        apiMemberRegistDao.registmember(member);

        Member member1 = apiMemberRegistDao.VerifyMemberName(member.getName());
        if (member1!=null){
            UserDto success = UserDto.success("恭喜用户:" + member.getName() + "注册成功，快登录试试吧", member);
            return success;
        }
        else {
            UserDto fail = UserDto.fail("注册失败！！");
            return fail;
        }

    }

    @Override
    public UserDto<Member> verifymember(Member member) {
        UserDto<Member> userDto;
        userDto = new UserDto<Member>();
        userDto.setData(member);
        //验证名字是否存在
        Member membername = apiMemberRegistDao.VerifyMemberName(member.getName());
        if (membername!=null){
            userDto = UserDto.fail("用户名已存在！！！");
            return userDto;
        }
        //验证邮箱是否存在
        Member memberemail = apiMemberRegistDao.VerifyMemberEmail(member.getEmail());
        if (memberemail!=null){
            userDto = UserDto.fail("电子邮箱已存在！！！");
            return userDto;
        }
        return UserDto.success("用户名和邮箱可用,输入电子邮箱的验证码注册！！！", userDto);
    }

    //判断性别的0和1
    public int IsSex(String sex){
        if ("men".equals(sex)){
            return 1;
        }
        else{
            return 0;
        }
    }

}
