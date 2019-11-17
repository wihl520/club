package com.gzqf.clubapi.service;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseService;

public interface ApiLoginService extends BaseService<Member> {

    Member getByNameAndPassword(Member member);

}
