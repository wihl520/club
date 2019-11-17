package com.gzqf.club.service;

import com.gzqf.club.entity.MemberDeadline;
import com.gzqf.club.persistence.BaseService;

import java.util.List;

public interface MemberDeadlineService extends BaseService<MemberDeadline> {
    void deleteMutil(List ids);
}
