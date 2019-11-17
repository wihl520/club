package com.gzqf.club.dao;

import com.gzqf.club.entity.MemberDeadline;
import com.gzqf.club.persistence.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDeadlineDao extends BaseDao<MemberDeadline> {
    void deleteMutil(@Param("ids") List ids);
}
