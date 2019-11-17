package com.gzqf.clubapi.service.impl;

import com.gzqf.club.entity.NewsPush;
import com.gzqf.clubapi.dao.PushDao;
import com.gzqf.clubapi.service.PushService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PushServiceImpl implements PushService{

    @Autowired
    private PushDao pushDao;

    @Override
    public List<NewsPush> getPush() {
        return pushDao.getPush();
    }
    @Override
    public NewsPush getPushId(int id) {
        return pushDao.getPushId(id);
    }
}
