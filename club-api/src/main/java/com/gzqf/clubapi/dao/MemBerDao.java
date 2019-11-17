package com.gzqf.clubapi.dao;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseDao;
import com.gzqf.club.persistence.Result;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MemBerDao extends BaseDao<Member> {

    /**
     * 删除多个id
     * @param ids
     */
    void deleteMutil(@Param("ids") List ids);


    void updateMemberday( Member member);
}
