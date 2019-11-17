package com.gzqf.club.service.impl;

import com.gzqf.club.dao.MemberDeadlineDao;
import com.gzqf.club.entity.MemberDeadline;
import com.gzqf.club.persistence.BaseServiceImpl;
import com.gzqf.club.service.MemberDeadlineService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberDeadlineServiceImpl extends BaseServiceImpl<MemberDeadline,MemberDeadlineDao> implements MemberDeadlineService {
    @Override
    public void deleteMutil(List ids) {
        dao.deleteMutil(ids);
    }
}
