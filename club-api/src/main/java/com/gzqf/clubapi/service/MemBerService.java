package com.gzqf.clubapi.service;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseService;
import com.gzqf.club.persistence.Result;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemBerService extends BaseService<Member> {


    /**
     * 删除多个id
     * @param ids
     */
    void deleteMutil(List ids);

    Result updateMemberday(Member member);
}
