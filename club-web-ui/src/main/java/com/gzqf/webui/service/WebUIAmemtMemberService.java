package com.gzqf.webui.service;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.UserDto;

public interface WebUIAmemtMemberService {

    UserDto<Member> amemt(Member member,String sex);

    UserDto<Member> amemdmemberpassword(Long id, String password, String newpassword);
}
