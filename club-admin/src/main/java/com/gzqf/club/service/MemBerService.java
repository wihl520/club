package com.gzqf.club.service;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseService;

import java.util.List;


public interface MemBerService extends BaseService<Member> {


    /**
     * 删除多个id
     * @param ids
     */
    void deleteMutil(List ids);

}
