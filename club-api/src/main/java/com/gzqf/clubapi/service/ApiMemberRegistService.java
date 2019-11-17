package com.gzqf.clubapi.service;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseService;
import com.gzqf.club.persistence.UserDto;


public interface ApiMemberRegistService extends BaseService<Member> {
    UserDto<Member> verifymember(Member member);

    UserDto<Member> registmember(Member member);

    UserDto<Member> memberament(Member member,String sex);

    UserDto<Member> amemdmemberpassword(String id, String password, String newpassword);
}
