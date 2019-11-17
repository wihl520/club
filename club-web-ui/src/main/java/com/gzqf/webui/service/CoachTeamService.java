package com.gzqf.webui.service;

import com.gzqf.club.entity.Member;

import java.util.List;

public interface CoachTeamService {
    List<Member> findList();

    Member findCoachById(String id);

    List<Member> findStuList(String id);
}
