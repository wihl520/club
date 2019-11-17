package com.gzqf.webui.service;

import com.gzqf.club.entity.Member;
import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.persistence.UserDto;

public interface LoginService {
    Result<User> checkUser(User user);

    UserDto<Member> queryUserDto(String cookieValue);

    UserDto VerificationCode(String verificationcode, String code, UserDto userDto);

    UserDto adminlogin(Member member);
}
