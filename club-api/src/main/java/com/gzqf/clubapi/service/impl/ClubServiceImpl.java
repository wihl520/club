package com.gzqf.clubapi.service.impl;

import com.gzqf.club.entity.Appcat;
import com.gzqf.club.entity.Member;
import com.gzqf.clubapi.dao.IClubapiDao;
import com.gzqf.clubapi.service.IClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubServiceImpl implements IClubService {
    @Autowired
    private IClubapiDao clubapiDao;

    @Override
    public List<Member> findList() {
        return clubapiDao.findList();
    }

    @Override
    public List<Appcat> findAppcatAll() {
        return clubapiDao.findAppcatAll();
    }

    @Override
    public Member findcoachInfo(Long id) {
        return clubapiDao.findcoachInfo(id);
    }

    @Override
    public List<Member> findStuList(Long id) {
        return clubapiDao.findStuList(id);
    }
}
