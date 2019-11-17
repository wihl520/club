package com.gzqf.clubapi.service.impl;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.clubapi.dao.ApiLoginDao;
import com.gzqf.clubapi.service.ApiLoginService;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class ApiLoginServiceImpl extends BaseServiceImpl<Member, ApiLoginDao> implements ApiLoginService {

    @Override
    public Member getByNameAndPassword(Member member) {
        /*使用加密方式*/
        String password = member.getPassword();
        member.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        Member byNameAndPassword = dao.getByNameAndPassword(member.getName(), member.getPassword());

        return byNameAndPassword;
    }
}
