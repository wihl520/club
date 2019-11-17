package com.gzqf.club.service;

import com.gzqf.club.entity.User;
import com.gzqf.club.persistence.BaseService;
import com.gzqf.club.persistence.Result;
import com.gzqf.club.persistence.UserDto;

public interface IUserService extends BaseService<User> {

    UserDto<User> VerificationCode(String verificationcode, String code,UserDto userDto);

    UserDto<User> adminlogin(User user);

    UserDto queryUserDto(String cookieValue);
}
