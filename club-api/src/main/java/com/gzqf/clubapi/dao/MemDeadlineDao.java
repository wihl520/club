package com.gzqf.clubapi.dao;

import com.gzqf.club.entity.MemberDeadline;
import com.gzqf.club.persistence.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemDeadlineDao extends BaseDao<MemberDeadline>{

    List<MemberDeadline> getDateList();

    void updateDate(MemberDeadline memDeadline);
}
