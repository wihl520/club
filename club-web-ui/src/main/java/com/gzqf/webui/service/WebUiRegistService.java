package com.gzqf.webui.service;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.UserDto;

public interface WebUiRegistService {
    //  注册操作
    UserDto<Member> registmember(Member member);

    //验证用户是否存在或者验证码错误,密码是否一致
    UserDto<Member> verify(Member member, String newcode, String code,String repassword);

    //对照电子验证码操作
     UserDto<Member> verifyEmailCode(UserDto<Member> userDto, String emailcode) ;
}
