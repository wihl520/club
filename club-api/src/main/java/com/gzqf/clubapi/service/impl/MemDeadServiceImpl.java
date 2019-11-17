package com.gzqf.clubapi.service.impl;


import com.gzqf.club.entity.MemberDeadline;
import com.gzqf.club.persistence.BaseServiceImpl;

import com.gzqf.clubapi.dao.MemDeadlineDao;
import com.gzqf.clubapi.service.MemDeadService;
import org.springframework.stereotype.Service;

@Service
public class MemDeadServiceImpl extends BaseServiceImpl<MemberDeadline,MemDeadlineDao> implements MemDeadService {

    @Override
    public void updateDate(MemberDeadline memDeadline) {
        dao.updateDate(memDeadline);
    }
}
