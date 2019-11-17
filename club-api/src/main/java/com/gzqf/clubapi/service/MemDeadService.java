package com.gzqf.clubapi.service;


import com.gzqf.club.entity.MemberDeadline;
import com.gzqf.club.persistence.BaseService;

public interface MemDeadService extends BaseService<MemberDeadline>{

    void updateDate(MemberDeadline memDeadline);
}
