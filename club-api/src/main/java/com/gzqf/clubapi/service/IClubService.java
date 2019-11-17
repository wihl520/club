package com.gzqf.clubapi.service;


import com.gzqf.club.entity.Appcat;
import com.gzqf.club.entity.Member;

import java.util.List;

public interface IClubService {
    List<Member> findList();
    List<Appcat> findAppcatAll();
    Member findcoachInfo(Long id);

    List<Member> findStuList(Long id);
}
