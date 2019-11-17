package com.gzqf.club.dao;

import com.gzqf.club.entity.Member;
import com.gzqf.club.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemBerDao extends BaseDao<Member> {

    /**
     * 删除多个id
     * @param ids
     */
    void deleteMutil(@Param("ids") List ids);

    List<Member> search(Member member);
}
