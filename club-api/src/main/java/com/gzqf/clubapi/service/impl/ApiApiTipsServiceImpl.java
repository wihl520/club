package com.gzqf.clubapi.service.impl;

import com.gzqf.club.entity.Tips;
import com.gzqf.clubapi.dao.TipsDao;
import com.gzqf.clubapi.service.ApiTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiApiTipsServiceImpl implements ApiTipsService {

    @Autowired
    private TipsDao tipsDao;

    @Override
    public List<Tips> getTipsList(Long id) {

        return  tipsDao.getTipsList(id);
    }
    @Override
    public Tips getTip(Long id) {
        return tipsDao.getTip(id);
    }
}
